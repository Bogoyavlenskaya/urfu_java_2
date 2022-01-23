package Service;

import Config.DbConnect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


class MechanismServiceTest {

    @Test
    @Rollback
    void testCreateNewParent() throws SQLException {
        String fullName="Igor";
        String address="Street Pushkin";
        Assertions.assertTrue(ParentService.createNewParent(fullName,address));
    }

    @Test
    @Rollback
    void createNewChild() throws SQLException {
        String fullName="Marlen";
        long parent_id=1;
        long educationInstitution_id=1;
        Assertions.assertTrue(ChildService.createNewChild(fullName,parent_id,educationInstitution_id));
    }

    @Test
    @Rollback
    void changeAddressAndEducationalInstitutionToChild() throws SQLException {
        int childId=1;
        String address="Kutuzov";
        int educationInstitution_id=1;
        Connection connection = DbConnect.connectDb();
        PreparedStatement selectRow=connection.prepareStatement("select * from children join parents p on p.id = children.parent_id\n" +
                "where children.id=? and address=? and educationalinstitution_id=?");
        selectRow.setInt(1,childId);
        selectRow.setString(2, address);
        selectRow.setInt(3, educationInstitution_id);
        ResultSet resultSet=selectRow.executeQuery();
        if(resultSet.next()==true){
            Assertions.assertTrue(true);
        }
        Assertions.assertFalse(false);
    }
}