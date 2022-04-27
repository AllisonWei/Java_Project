package business.DB4OUtil;

import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import business.dto.UserDto;
import business.exception.CommonException;
import business.type.OrganizationType;

public class UserDBUtil {
    public static void initSave(List<UserDto> userList) {
        if (userList.isEmpty()) {
            return;
        }
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            for (UserDto userDto : userList) {
                conn.store(userDto);
            }
            conn.commit();
        } finally {
            conn.close();
        }
    }
    
    public static synchronized void save(UserDto userDto) {
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<UserDto> userList = conn.query(new Predicate<UserDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(UserDto arg0) {
                    return arg0.getUserName().equals(userDto.getUserName());
                }
            });
            if (!userList.isEmpty()) {
                throw new CommonException("FAILED", "Sorry, the username has existed!");
            }
            
            if (userDto.getOrganization().getOrgnaizationName()
                .equals(OrganizationType.Restaurant.getValue())) {
                userList = conn.query(new Predicate<UserDto>() {
                    private static final long serialVersionUID = 1L;
                    @Override
                    public boolean match(UserDto arg0) {
                        return arg0.getRestaurantName().equals(userDto.getRestaurantName());
                    }
                });
                if (!userList.isEmpty()) {
                    throw new CommonException("FAILED", "The Restaurant has Existed!");
                }
            }
            conn.store(userDto);
            conn.commit();
        } finally {
            conn.close();
        }
    }
    
    public static synchronized void update(UserDto userDto) {
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<UserDto> userList = conn.query(new Predicate<UserDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(UserDto arg0) {
                    return arg0.getUserName().equals(userDto.getUserName())
                        && !arg0.getId().equals(userDto.getId());
                }
            });
            if (!userList.isEmpty()) {
                throw new CommonException("FAILED", "Sorry, the username has existed!");
            }
            
            if (userDto.getOrganization().getOrgnaizationName()
                .equals(OrganizationType.Restaurant.getValue())) {
                userList = conn.query(new Predicate<UserDto>() {
                    private static final long serialVersionUID = 1L;
                    @Override
                    public boolean match(UserDto arg0) {
                        return arg0.getRestaurantName().equals(userDto.getRestaurantName())
                            && !arg0.getId().equals(userDto.getId());
                    }
                });
                if (!userList.isEmpty()) {
                    throw new CommonException("FAILED", "The Restaurant has Existed!");
                }
            }
            
            ObjectSet<UserDto> systems = conn.query(new Predicate<UserDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(UserDto arg0) {
                    return arg0.getId().equals(userDto.getId());
                }
            });
            if (!systems.isEmpty()) {
                UserDto updateUser = systems.get(0);
                updateUser.setOrganization(userDto.getOrganization());
                updateUser.setPassword(userDto.getPassword());
                updateUser.setPerson(userDto.getPerson());
                updateUser.setRole(userDto.getRole());
                updateUser.setUserName(userDto.getUserName());
                updateUser.setRestaurantName(userDto.getRestaurantName());
                conn.store(updateUser);
                conn.commit();
            }
        } finally {
            conn.close();
        }
    }
    
    public static <T> List<T> queryList(Class<T> zClass){
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<T> systems = conn.query(zClass);
            return new ArrayList<>(systems);
        } finally {
            conn.close();
        }
    }
    
    public static UserDto queryByUserName(String userName){
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<UserDto> systems = conn.query(new Predicate<UserDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(UserDto arg0) {
                    return arg0.getUserName().equals(userName);
                }
            });
            return systems.isEmpty() ? null : systems.get(0);
        } finally {
            conn.close();
        }
    }
    
    public static UserDto queryById(String id){
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<UserDto> systems = conn.query(new Predicate<UserDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(UserDto arg0) {
                    return arg0.getId().equals(id);
                }
            });
            return systems.isEmpty() ? null : systems.get(0);
        } finally {
            conn.close();
        }
    }
    
    public static List<UserDto> queryByOrg(String orgName){
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<UserDto> systems = conn.query(new Predicate<UserDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(UserDto arg0) {
                    return arg0.getOrganization().getOrgnaizationName().equals(orgName);
                }
            });
            return new ArrayList<>(systems);
        } finally {
            conn.close();
        }
    }
    
    public static void remove(UserDto userDto) {
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<UserDto> systems = conn.query(new Predicate<UserDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(UserDto arg0) {
                    return arg0.getId().equals(userDto.getId());
                }
            });
            if (!systems.isEmpty()) {
                conn.delete(systems.get(0));
            }
        } finally {
            conn.close();
        }
    }
}
