package com.emergentes.dao;

import com.emergentes.modelo.Almacen;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlmacenDAOimple extends ConexionDB implements AlmacenDAO {

    @Override
    public void insert(Almacen TEM) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO productos (descripcion,cantidad,precio,categoria) VALUES(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, TEM.getDescripcion());
            ps.setInt(2, TEM.getCantidad());
            ps.setFloat(3, TEM.getPrecio());
            ps.setString(4, TEM.getCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Almacen TEM) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos SET descripcion=?, cantidad=?, precio=?, categoria=? WHERE ?=id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, TEM.getDescripcion());
            ps.setInt(2, TEM.getCantidad());
            ps.setFloat(3, TEM.getPrecio());
            ps.setString(4, TEM.getCategoria());
            ps.setInt(5,TEM.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            String sql = "DELETE FROM productos WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Almacen getById(int id) throws Exception {
         Almacen RQ = new Almacen();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
           

            if (rs.next()) {
                RQ.setId(rs.getInt("id"));
                RQ.setDescripcion(rs.getString("descripcion"));
                RQ.setCantidad(rs.getInt("cantidad"));
                RQ.setPrecio(rs.getFloat("precio"));
                RQ.setCategoria(rs.getString("categoria"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return RQ;

    }

    @Override
    public List<Almacen> getAll() throws Exception {
        ArrayList<Almacen> lista = new ArrayList<Almacen>();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Almacen avi = new Almacen();
                avi.setId(rs.getInt("id"));
                avi.setDescripcion(rs.getString("descripcion"));
                avi.setCantidad(rs.getInt("cantidad"));
                avi.setPrecio(rs.getFloat("precio"));
                avi.setCategoria(rs.getString("categoria"));

                lista.add(avi);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;

    }

}
