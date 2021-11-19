package Job4j.it.JSONParser;

import com.google.gson.Gson;
import lombok.Data;

import java.util.List;

@Data
public class UserInfoDTO {

    private String inputData;
    private String lastName;
    private String firstName;
    private String organizationId;
    private String patronymic;
    private String positionName;
    private String preferred_username;
    private String subdivisionName;
    private String status;
    private Realm_access realm_access;
    private Resource_access resource_access;


    public static void main(String[] args) {
        String input = "{\"sub\":\"a00d33c2-37dd-407b-98e4-2d9f5871499d\"," +
                "\"lastName\":\"пятьдесятвосемь\"," +
                "\"resource_access\":{\"sbercare\":{\"roles\":[\"ROLE_CHAT_OPERATOR\"]}," +
                "\"account\":{\"roles\":[\"manage-account\",\"manage-account-links\",\"view-profile\"]}," +
                "\"Sberfriend\":{\"roles\":[\"SBERFRIEND_USER\"]}}," +
                "\"birthdate\":\"1997-08-30\"," +
                "\"organizationName\":\"ПАО Сбербанк\"," +
                "\"preferred_username\":\"907561850\"," +
                "\"positionName\":\"Танкист\"," +
                "\"organizationId\":\"899bb858-4010-4d7f-b58d-1233fc476702\"," +
                "\"firstName\":\"Аккаунт\"," +
                "\"patronymic\":\"ИФТ\"," +
                "\"realm_access\":{\"roles\":[\"default-roles-suid\"," +
                "\"User\",\"uma_authorization\"]}," +
                "\"subdivisionName\":\"Управление делами\"," +
                "\"status\":\"true\"}";
        Gson gson = new Gson();
        UserInfoDTO userInfoDTO = gson.fromJson(input, UserInfoDTO.class);
        System.out.println(userInfoDTO.firstName);
        List<String> roles = userInfoDTO.realm_access.roles;
        for (String s: roles
             ) {
            System.out.println(s);
        }
        Sbercare sbercare = userInfoDTO.resource_access.sbercare;
        for (String s: sbercare.roles
             ) {
            System.out.println(s);
        }
    }
}

@Data
 class Account {
    public List<String> roles;
 }

@Data
 class SberFriend {
     public List<String> roles;
 }

@Data
 class Realm_access {
     public List<String> roles;
 }



