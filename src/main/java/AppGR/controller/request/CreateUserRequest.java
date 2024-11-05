
package AppGR.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequest {
    public String name;
    public long document;
    public long cellphone;
    public String username;
    public String password;
    public long partnerid;
}
