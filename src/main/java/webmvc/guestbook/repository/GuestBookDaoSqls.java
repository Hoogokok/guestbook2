package webmvc.guestbook.repository;

public class GuestBookDaoSqls {
    public static final String DELETE_BY_ID = "DELETE FROM guestbook2 WHERE no = :no";
    public static final String SELECT_ALL = "SELECT no,name,content,reg_date FROM guestbook2";
    public static final String FIND_PASSWORD = "SELECT PASSWORD  FROM GUESTBOOK2 WHERE NO = :no";
}
