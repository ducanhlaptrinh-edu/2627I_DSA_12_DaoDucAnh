package week4_sorts;

import java.util.Comparator;

public class StudentComparable{
    private double CGPA;
    private String name;
    private int id;
    public StudentComparable(double CGPA, String name, int id){
        this.CGPA = CGPA;
        this.name = name;
        this.id = id;
    }
    double getCGPA(){
        return this.CGPA;
    }
    String getName(){
        return this.name;
    }
    int getId(){
        return this.id;
    }
}
class StudentComparator implements Comparator<StudentComparable>{
    @Override
    public int compare(StudentComparable s1, StudentComparable s2) {
        int gpaCompare = Double.compare(s2.getCGPA(), s1.getCGPA());
        if(gpaCompare != 0){
            return gpaCompare;
        }
        int nameCompare = s1.getName().compareTo(s2.getName());
        if(nameCompare != 0){
            return nameCompare;
        }
        int idCompare = Integer.compare(s1.getId(), s2.getId());
        if(idCompare != 0){
            return idCompare;
        }
        return 0;
    }
}



