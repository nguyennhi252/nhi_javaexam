package entity;

public class User {
        private int userId;
        private String fullName;
        private String email;
        private String password;
        private Role role;
        private Integer expInYear;
        private String proSkill;

        public User() {
        }

        public User(int userId, String fullName, String email, String password, Role role, Integer expInYear, String proSkill) {
            this.userId = userId;
            this.fullName = fullName;
            this.email = email;
            this.password = password;
            this.role = role;
            this.expInYear = expInYear;
            this.proSkill = proSkill;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userId=" + userId +
                    ", fullName='" + fullName + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", role=" + role +
                    ", expInYear=" + expInYear +
                    ", proSkill='" + proSkill + '\'' +
                    '}';
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        public Integer getExpInYear() {
            return expInYear;
        }

        public void setExpInYear(Integer expInYear) {
            this.expInYear = expInYear;
        }

        public String getProSkill() {
            return proSkill;
        }

        public void setProSkill(String proSkill) {
            this.proSkill = proSkill;
        }
    }




