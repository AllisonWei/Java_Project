package business.DB4OUtil;

import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import business.dto.RestaurantMenuDto;

public class RestaurantMenuDBUtil {
    public static void initSave(List<RestaurantMenuDto> menuList) {
        if (menuList.isEmpty()) {
            return;
        }
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            for (RestaurantMenuDto menuDto : menuList) {
                conn.store(menuDto);
            }
            conn.commit();
        } finally {
            conn.close();
        }
    }
    
    public static synchronized void update(RestaurantMenuDto menuDto) {
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<RestaurantMenuDto> systems = conn.query(new Predicate<RestaurantMenuDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(RestaurantMenuDto arg0) {
                    return arg0.getId().equals(menuDto.getId());
                }
            });
            if (!systems.isEmpty()) {
                RestaurantMenuDto menu = systems.get(0);
                menu.setMeal(menuDto.getMeal());
                menu.setPrice(menuDto.getPrice());
                conn.store(menu);
                conn.commit();
            }
        } finally {
            conn.close();
        }
    }
    
    public static RestaurantMenuDto queryById(String id){
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<RestaurantMenuDto> systems = conn.query(new Predicate<RestaurantMenuDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(RestaurantMenuDto arg0) {
                    return arg0.getId().equals(id);
                }
            });
            return systems.isEmpty() ? null : systems.get(0);
        } finally {
            conn.close();
        }
    }
    
    public static List<RestaurantMenuDto> queryByRelId(String relId){
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<RestaurantMenuDto> systems = conn.query(new Predicate<RestaurantMenuDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(RestaurantMenuDto arg0) {
                    return arg0.getRelId().equals(relId);
                }
            });
            return new ArrayList<>(systems);
        } finally {
            conn.close();
        }
    }
    
    public static void remove(RestaurantMenuDto menuDto) {
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<RestaurantMenuDto> systems = conn.query(new Predicate<RestaurantMenuDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(RestaurantMenuDto arg0) {
                    return arg0.getId().equals(menuDto.getId());
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
