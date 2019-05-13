package repository;

public class UserRepository extends BaseRepository{

    public String getUserLocale(Long id){
        this.setQuery("select locale from Users where id = ?");
        return "";
    }
}
