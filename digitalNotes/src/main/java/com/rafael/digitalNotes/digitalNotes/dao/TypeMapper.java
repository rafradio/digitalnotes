/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.digitalNotes.digitalNotes.dao;

import com.rafael.digitalNotes.digitalNotes.models.TypeOfNote;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TypeMapper implements RowMapper<TypeOfNote> {
    
    @Override
    public TypeOfNote mapRow(ResultSet rs, int rowNum) throws SQLException {
        TypeOfNote type = new TypeOfNote();
        type.setId(rs.getInt("id"));
        type.setTypename(rs.getString("typename"));
        type.setIcon(rs.getString("icon"));
        type.setColor(rs.getString("color"));
        type.setDate(rs.getDate("date"));
        return type;
    }
}
