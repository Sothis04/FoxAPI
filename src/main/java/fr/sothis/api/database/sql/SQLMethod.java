package fr.sothis.api.database.sql;

import fr.sothis.api.FoxApi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

public class SQLMethod {

    public void update(String keyConnection, String qry){
        try (Connection c = FoxApi.getINSTANCE().getConnexionSQL(keyConnection); PreparedStatement s = c.prepareStatement(qry)) {
            s.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object query(String keyConnection, String qry, Function<ResultSet, Object> consumer) {
        try (Connection c = FoxApi.getINSTANCE().getConnexionSQL(keyConnection);
             PreparedStatement s = c.prepareStatement(qry);
             ResultSet rs = s.executeQuery()) {
            return consumer.apply(rs);
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public void query(String keyConnection, String qry, Consumer<ResultSet> consumer){
        try (Connection c = FoxApi.getINSTANCE().getConnexionSQL(keyConnection);
             PreparedStatement s = c.prepareStatement(qry);
             ResultSet rs = s.executeQuery()) {
            consumer.accept(rs);
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
