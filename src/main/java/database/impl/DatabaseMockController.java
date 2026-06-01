package database.impl;

import java.util.ArrayList;
import java.util.List;

import entity.Admin;
import entity.Sungai;
import entity.User;
import entity.impl.NewComment;

public class DatabaseMockController {
    public static List<User> users = new ArrayList<>();
    public static int userIdCounter = 0;

    public static List<Sungai> sungaiList = new ArrayList<>();
    public static int sungaiIdCounter = 0;

    public static List<Admin> admins = new ArrayList<>();
    public static int adminIdCounter = 0;

    public static List<NewComment> komentarList = new ArrayList<>();
    public static int commentIdCounter = 0;
}
