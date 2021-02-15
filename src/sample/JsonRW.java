package sample;
//
//import org.json.simple.parser.JSONParser;
//import org.json.simple.JSONObject;
//
//import java.io.BufferedInputStream;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
public class JsonRW {
//    static String start_t = "";
//    static String stop_t = "";
//    static int disk1_speed = 1;
//    static int disk2_speed = 1;
//    static String tmp = "h";
//    static double disk1_an = 0.0;
//    static double disk2_an = 0.0;
//    static int top_on = 2;
//
//    JsonRW(){
//        String res = "";
//        String fileName = "data.json";
//        try{
//            FileInputStream ifs = new FileInputStream(fileName);
//            BufferedInputStream reader = new BufferedInputStream(ifs);
//            int sz = 0;
//            while((sz = reader.available()) > 0){
//                byte buf[] = new byte[sz];
//                reader.read(buf);
//                res += new String(buf);
//            }
//            readJson(res);
//        }catch (Exception e){
//            System.out.println("Some Errors: ");
//        }
//    }
//    public static void setAngle(){
//        if (!start_t.equals("") && !stop_t.equals("")){
//            String[] starts = start_t.split(" ");
//            String[] start_D = starts[0].split("-");
//            String[] start_T = starts[1].split(":");
//            String[] stops = stop_t.split(" ");
//            String[] stop_D = stops[0].split("-");
//            String[] stop_T = stops[1].split(":");
//
//            int start_m = Integer.valueOf(start_T[1]);
//            int start_h = Integer.valueOf(start_T[0]);
//            int start_s = Integer.valueOf(start_T[2]);
//            int start_date = Integer.valueOf(start_D[2]);
//            int start_month = Integer.valueOf(start_D[1]);
//            int start_year = Integer.valueOf(start_D[0]);
//
//            int stop_m = Integer.valueOf(stop_T[1]);
//            int stop_h = Integer.valueOf(stop_T[0]);
//            int stop_s = Integer.valueOf(stop_T[2]);
//            int stop_date = Integer.valueOf(stop_D[2]);
//            int stop_month = Integer.valueOf(stop_D[1]);
//            int stop_year = Integer.valueOf(stop_D[0]);
//
//            int start_seconds = start_h*3600 + start_m*60 + start_s;
//            int stop_seconds = stop_h*3600 + stop_m*60 + stop_s;
//
//            int total_s = 0;
//            if (start_seconds > stop_seconds){
//                total_s = 24*3600 + stop_seconds - start_seconds;
//            }else {
//                total_s = stop_seconds - start_seconds;
//            }
//            if (tmp.equals("h")){
//                disk1_an = disk1_an + ((double)(total_s*360)) / (disk1_speed*3600);
//                disk2_an = disk2_an + ((double)(total_s*360)) / (disk2_speed*3600);
//            }else {
//                disk1_an = disk1_an + (total_s*360) / (disk1_speed*60);
//                disk2_an = disk2_an + (total_s*360) / (disk2_speed*60);
//            }
//            System.out.println(disk1_an);
//            System.out.println(disk2_an);
//            disk1_an = disk1_an - ((int)(disk1_an/360)*360);
//            disk2_an = disk2_an - ((int)(disk2_an/360)*360);
//            System.out.println(disk1_an);
//            System.out.println(disk2_an);
//
//        }else {
//            disk1_an = 0.0;
//            disk2_an = 0.0;
//        }
//    }
//    public static boolean readJson(String string){
//        try{
//            JSONParser parser = new JSONParser();
//            JSONObject jsonObject = (JSONObject)parser.parse(string);
//            tmp = (String)jsonObject.get("tmp");
//            disk1_speed = Integer.valueOf((String)jsonObject.get("disk1_speed"));
//            disk2_speed = Integer.valueOf((String)jsonObject.get("disk2_speed"));
//            top_on = Integer.valueOf((String)jsonObject.get("top_on"));
//            disk1_an = Double.valueOf((String)jsonObject.get("disk1_an"));
//            disk2_an = Double.valueOf((String)jsonObject.get("disk2_an"));
//            start_t = (String)jsonObject.get("start_t");
//            stop_t = (String)jsonObject.get("stop_t");
//            if (!start_t.equals("") && !stop_t.equals("")){
//                start_t = (String)jsonObject.get("stop_t");
//                DateFormat stop_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                Date stop_date = new Date();
//                stop_t = stop_Format.format(stop_date);
//                setAngle();
//            }
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//    }
//    public static boolean writeJson(){
//        String fileName = "data.json";
//        JSONObject obj = new JSONObject();
//        obj.put("disk1_an", Double.toString(disk1_an));
//        obj.put("disk2_an", Double.toString(disk2_an));
//        obj.put("start_t", start_t);
//        obj.put("stop_t", stop_t);
//        obj.put("disk1_speed", Integer.toString(disk1_speed));
//        obj.put("disk2_speed", Integer.toString(disk2_speed));
//        obj.put("tmp", tmp);
//        obj.put("top_on", Integer.toString(top_on));
//        try (FileWriter fileWriter = new FileWriter(fileName)){
//            fileWriter.write(obj.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    public static Thread angle_thread =  new Thread(new Runnable() {
//        @Override
//        public void run() {
//            while (true){
//                try {
//                    Thread.sleep(10000);
//                    DateFormat stop_dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    Date stop_date = new Date();
//                    start_t = stop_t;
//                    stop_t = stop_dateFormat.format(stop_date);
//                    setAngle();
//                    writeJson();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    });
}
//
//
//
//
