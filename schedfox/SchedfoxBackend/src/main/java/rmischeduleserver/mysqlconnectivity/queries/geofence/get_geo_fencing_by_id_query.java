/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmischeduleserver.mysqlconnectivity.queries.geofence;

import rmischeduleserver.mysqlconnectivity.queries.GeneralQueryFormat;

/**
 *
 * @author ira
 */
public class get_geo_fencing_by_id_query extends GeneralQueryFormat {

    @Override
    public boolean hasAccess() {
        return true;
    }
    
    @Override
    public boolean hasPreparedStatement() {
        return true;
    }
    
    @Override
    public String getPreparedStatementString() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ");
        sql.append("geo_fencing ");
        sql.append("WHERE ");
        sql.append("geo_fencing_id = ?; ");
        return sql.toString();
    }
    
}
