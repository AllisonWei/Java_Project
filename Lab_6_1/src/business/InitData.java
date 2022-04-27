package business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import business.DB4OUtil.RestaurantMenuDBUtil;
import business.DB4OUtil.UserDBUtil;
import business.dto.OrganizationDto;
import business.dto.PersonDto;
import business.dto.RestaurantMenuDto;
import business.dto.RoleDto;
import business.dto.UserDto;
import business.exception.CommonException;

public class InitData {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("init_data_1.txt"));
        List<UserDto> userList = new ArrayList<>();
        List<RestaurantMenuDto> menuList = new ArrayList<>();
        int type = 0;
        int fieldCount = 0;
        for (String line : lines) {
            if (line.startsWith("### Admin Organization")) {
                type = 1;
                fieldCount = 5;
            } else if (line.startsWith("### Restaurant Organization")) {
                type = 2;
                fieldCount = 6;
            } else if (line.startsWith("### Customer Organization")) {
                type = 1;
                fieldCount = 5;
            } else if (line.startsWith("### Delivery Organization")) {
                type = 1;
                fieldCount = 5;
            } else if (line.startsWith("### Restaurant Menu")) {
                type = 3;
                fieldCount = 4;
            } else if (!line.startsWith("##") && !line.trim().isEmpty()){
                if(type == 1) {
                    if (line.split("\\|", -1).length != fieldCount) {
                        throw new CommonException("FAILED", "Template provision error");
                    }
                    String[] fields = line.split("\\|", -1);
                    UserDto userDto = new UserDto(fields[0].trim(), 
                        fields[1].trim(), 
                        new RoleDto(fields[2].trim()), 
                        new OrganizationDto(fields[3].trim()), 
                        new PersonDto(fields[4].trim()));
                    userList.add(userDto);
                }
                else if(type == 2) {
                    if (line.split("\\|", -1).length != fieldCount) {
                        throw new CommonException("FAILED", "Template provision error");
                    }
                    String[] fields = line.split("\\|", -1);
                    UserDto userDto = new UserDto(fields[0].trim(), 
                        fields[1].trim(), 
                        new RoleDto(fields[2].trim()), 
                        new OrganizationDto(fields[3].trim()), 
                        new PersonDto(fields[4].trim()),
                        fields[5].trim());
                    userList.add(userDto);
                }
                else if(type == 3) {
                    if (line.split("\\|", -1).length != fieldCount) {
                        throw new CommonException("FAILED", "Template provision error");
                    }
                    String[] fields = line.split("\\|", -1);
                    String userName = fields[0].trim();
                    UserDto userDto = getUserDtoByUserName(userList, userName);
                    RestaurantMenuDto menuDto = new RestaurantMenuDto(
                        userDto.getId(), fields[2].trim(), fields[3].trim());
                    menuList.add(menuDto);
                }
            }
        }
        // inert db
        UserDBUtil.initSave(userList);
        RestaurantMenuDBUtil.initSave(menuList);
    }
    
    public static UserDto getUserDtoByUserName(List<UserDto> userList, String userName) {
        for (UserDto userDto : userList) {
            if (userDto.getUserName().equals(userName)) {
                return userDto;
            }
        }
        
        throw new CommonException("FAILED", "Sorry, the user name not matched!");
    }
    
    public static void checkExistUserName(List<UserDto> userList, String userName) {
        for (UserDto userDto : userList) {
            if (userDto.getUserName().equals(userName)) {
                throw new CommonException("FAILED", "Sorry, the user name configuration duplicated!");
            }
        }
    }
    
    
    public static void checkNotExistUserName(List<UserDto> userList, String userName) {
        UserDto userDto = getUserDtoByUserName(userList, userName);
        if (null == userDto) {
            throw new CommonException("FAILED", "Sorry, the user name not matched!");
        }
    }
}
