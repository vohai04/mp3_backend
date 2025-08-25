package mp3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "UserRoles", schema = "dbo")
@Data
@NoArgsConstructor
public class UserRole {

    @EmbeddedId
    private UserRoleId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "RoleId", nullable = false)
    private Role role;

    @Embeddable
    public static class UserRoleId implements Serializable {
        @Column(name = "UserId")
        private Long userId;

        @Column(name = "RoleId")
        private Long roleId;

        // Getters, setters, equals, hashCode
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserRoleId that = (UserRoleId) o;
            return userId.equals(that.userId) && roleId.equals(that.roleId);
        }

        @Override
        public int hashCode() {
            return 31 * userId.hashCode() + roleId.hashCode();
        }
    }
}