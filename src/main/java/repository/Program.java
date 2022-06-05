package repository;

import entity.Role;
import entity.User;

import java.util.List;

public class Program {

    public static void main(String[] args) {
//        bai2();
//        bai3(1);
        bai4(3);
        taoUser();
    }

    static void bai2() {
        List<User> all = UserRepository.findAll();
        System.out.printf("%-10s | %-20s | %-15s\n", "ID", "FULL_NAME", "EMAIL");
        System.out.println("____________________________________________________________");
        for (User user : all) {
            System.out.printf("%-10s | %-20s | %-15s\n", user.getUserId(), user.getFullName(), user.getEmail());
        }
    }

    static void bai3(int userId) {
        User user = UserRepository.findById(userId);
        System.out.println(user);
    }
    static void bai4(int userId){
        boolean b = UserRepository.deletedId(userId);
        if(b){
            System.out.println("Xoa thanh cong");
        }else {
            System.out.println("xoa khong thanh cong");
        }
    }
    static void taoUser(){
        User user1 =new User();
        user1.setFullName("Phuong Nhi");
        user1.setEmail("nhi@gmail.com");
        user1.setPassword("1344nn");
        user1.setRole(Role.EMPLOYEE);
        user1.setProSkill("Java");
        user1.setExpInYear(1);
        UserRepository.createUser(user1);
    }


}


