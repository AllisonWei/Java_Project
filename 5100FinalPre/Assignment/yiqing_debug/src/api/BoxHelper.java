package api;

public class BoxHelper<T> {
    String id;
    
    T data;

    public BoxHelper(String id, T data) {
        super();
        this.id = id;
        this.data = data;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return id;
    }
}
