package model.dao.impl;

import db.DB;
import db.DbException;
import entities.Department;
import entities.Seller;
import model.dao.DepartmentDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    public void insert(Department dep){
        PreparedStatement st = null;
        try {
            st =conn.prepareStatement("INSERT INTO department "
                            +"(Name) "
                            + "VALUES(?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, dep.getName());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected>0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    dep.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else{
                throw new DbException("Erro inesperado! Nenhuma linha alterada");
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    };
    public void update(Department dep){
        PreparedStatement st = null;
        try {
            st =conn.prepareStatement("UPDATE department "
                    +"SET Name = ? "
                    + "WHERE Id = ?");
            st.setString(1,dep.getName());
            st.setInt(2, dep.getId());

            st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    };
    public void deleteById(Integer id){
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM department WHERE id = ?");

            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    };
    public Department findById(Integer id){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * from department "
                            +"where department.id = ?" );
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                Department dep = new Department();
                dep.setId(rs.getInt("Id"));
                dep.setName(rs.getString("Name"));
                return dep;
            }
            return null;

        }catch (SQLException e){
            throw  new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    };
    public List<Department> findAll(){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT *"
                            + "From department "
                            +"order by Id"
            );

            rs = st.executeQuery();


            List<Department> list = new ArrayList<>();

            while(rs.next()){
                Department dep = new Department();
                dep.setId(rs.getInt("Id"));
                dep.setName(rs.getString("Name"));
                list.add(dep);
            }
            return list;

        }catch (SQLException e){
            throw  new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    };
}
