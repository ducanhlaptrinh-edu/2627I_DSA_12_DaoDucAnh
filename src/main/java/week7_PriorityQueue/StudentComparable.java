package week7_PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class StudentComparable {
    private int id;
    private String name;
    private double CGPA;
    public StudentComparable(int id, String name, double CGPA){
        this.id = id;
        this.name = name;
        this.CGPA = CGPA;
    }
    public int getId() {
        return id;
    }
    public double getCGPA() {
        return CGPA;
    }
    public String getName() {
        return name;
    }
}

class Prioirities{
    public List<StudentComparable> getStudents(List<String> events){
        PriorityQueue<StudentComparable> pq = new PriorityQueue<>(new Comparator<StudentComparable>(){
            @Override
            public int compare(StudentComparable s1, StudentComparable s2){
                int gpaCompare = Double.compare(s2.getCGPA(), s1.getCGPA());
                if(gpaCompare != 0){return gpaCompare;}
                int nameCompare = s1.getName().compareTo(s2.getName());
                if(nameCompare != 0){return nameCompare;}
                return Double.compare(s1.getId(), s2.getId());
            }
        });
        for(String event: events){
            String[] parts =  event.split(" ");
            String options =  parts[0];
            String name  = parts[1];
            String CGPAs = parts[2];
            String ids  = parts[3];
            if(options.equals("ENTER")){
                double CGPA = Double.parseDouble(CGPAs);
                int id = Integer.parseInt(ids);
                pq.add(new StudentComparable(id, name, CGPA));
            }else if(options.equals("SERVED")){
                if(!pq.isEmpty()){
                    pq.poll();
                }
            }
        }
        List<StudentComparable> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        return result;
    }
}
