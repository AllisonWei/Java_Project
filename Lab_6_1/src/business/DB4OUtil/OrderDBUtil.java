package business.DB4OUtil;

import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import business.dto.OrderDto;

public class OrderDBUtil {
    public static synchronized void update(OrderDto orderDto) {
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<OrderDto> systems = conn.query(new Predicate<OrderDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(OrderDto arg0) {
                    return arg0.getId().equals(orderDto.getId());
                }
            });
            if (!systems.isEmpty()) {
                OrderDto orderT = systems.get(0);
                orderT.setComment(orderDto.getComment());
                orderT.setDeliveryName(orderDto.getDeliveryName());
                orderT.setRestaurantName(orderDto.getRestaurantName());
                orderT.setStatus(orderDto.getStatus());
                orderT.setMeal(orderDto.getMeal());
                conn.store(orderT);
                conn.commit();
            }
        } finally {
            conn.close();
        }
    }
    
    public static OrderDto queryById(String id){
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<OrderDto> systems = conn.query(new Predicate<OrderDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(OrderDto arg0) {
                    return arg0.getId().equals(id);
                }
            });
            return systems.isEmpty() ? null : systems.get(0);
        } finally {
            conn.close();
        }
    }
    
    public static List<OrderDto> queryByRestName(String restName){
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<OrderDto> systems = conn.query(new Predicate<OrderDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(OrderDto arg0) {
                    return arg0.getRestaurantName().equals(restName);
                }
            });
            return new ArrayList<>(systems);
        } finally {
            conn.close();
        }
    }
    
    
    public static List<OrderDto> queryByDelName(String delName){
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<OrderDto> systems = conn.query(new Predicate<OrderDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(OrderDto arg0) {
                    return arg0.getDeliveryName().equals(delName);
                }
            });
            return new ArrayList<>(systems);
        } finally {
            conn.close();
        }
    }
    
    public static List<OrderDto> queryByUserName(String userName){
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<OrderDto> systems = conn.query(new Predicate<OrderDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(OrderDto arg0) {
                    return arg0.getUserName().equals(userName);
                }
            });
            return new ArrayList<>(systems);
        } finally {
            conn.close();
        }
    }
    
    public static void remove(OrderDto orderDto) {
        ObjectContainer conn = DB4OUtil.getInstance().createConnection();
        try {
            ObjectSet<OrderDto> systems = conn.query(new Predicate<OrderDto>() {
                private static final long serialVersionUID = 1L;
                @Override
                public boolean match(OrderDto arg0) {
                    return arg0.getId().equals(orderDto.getId());
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
