package board.toyboard.DTO;

import board.toyboard.Entity.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserDTO {
    private Long id;
    private String name;

    public UserDTO(){}
    public UserDTO(User user){
        id=user.getId();
        name=user.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
