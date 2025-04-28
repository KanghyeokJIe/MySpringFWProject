package mylab.user.di.xml;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	// @Value("MySQL")
    private String dbType = "MySQL"; // 기본값 설정

    public UserRepository() {}

    public String getDbType() { return dbType; }
    public void setDbType(String dbType) { this.dbType = dbType; }

    public boolean saveUser(String userId, String name) {
        System.out.println("사용자 저장: " + userId + ", " + name + " (DB: " + dbType + ")");
        return true;
    }

    @Override
    public String toString() {
        return "UserRepository [dbType=" + dbType + "]";
    }
}
