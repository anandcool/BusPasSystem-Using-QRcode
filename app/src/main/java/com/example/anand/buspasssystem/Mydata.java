package com.example.anand.buspasssystem;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Mydata {
    public static String signup(String fname, String pass, String email, String pno) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/signup.php?"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("fname", CHAR_SET) + "=" + URLEncoder.encode(fname, CHAR_SET);
            data += "&" + URLEncoder.encode("pass", CHAR_SET) + "=" + URLEncoder.encode(pass, CHAR_SET);
            data += "&" + URLEncoder.encode("email", CHAR_SET) + "=" + URLEncoder.encode(email, CHAR_SET);
            data += "&" + URLEncoder.encode("pno", CHAR_SET) + "=" + URLEncoder.encode(pno, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (UnsupportedEncodingException e) {
            response = response + e.getMessage();
            e.printStackTrace();

        } catch (IOException io) {
            response = response + io.getMessage();
        } finally {
            if (output != null) try {
                output.close();
            } catch (IOException ignoreIO) {
            }
        }


        return response;

    }

    public static String login(String email, String pass) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/login.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "email=" + email + "&pass=" + pass;
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception e) {
//          Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;

    }

    public static String busadd(String busname, String busfrom, String busto, String bustiming) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/busadd.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("busname", CHAR_SET) + "=" + URLEncoder.encode(busname, CHAR_SET);
            data += "&" + URLEncoder.encode("busfrom", CHAR_SET) + "=" + URLEncoder.encode(busfrom, CHAR_SET);
            data += "&" + URLEncoder.encode("busto", CHAR_SET) + "=" + URLEncoder.encode(busto, CHAR_SET);
            data += "&" + URLEncoder.encode("bustiming", CHAR_SET) + "=" + URLEncoder.encode(bustiming, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (UnsupportedEncodingException e) {
            response = response + e.getMessage();
            e.printStackTrace();

        } catch (IOException io) {
            response = response + io.getMessage();
        } finally {
            if (output != null) try {
                output.close();
            } catch (IOException ignoreIO) {
            }
        }


        return response;

    }

    public static String checkbus(String busfrom, String busto) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/checkbus.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "busfrom=" + busfrom + "&busto=" + busto;
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception e) {
//          Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

    public static String busarrivalplaces() {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/busarrivalplaces.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception ex) {
//            Toast.makeText(null,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

    public static String busdestinationplaces() {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/busdestinationplaces.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception ex) {
//            Toast.makeText(null,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

    public static String bookseat(String bus_name, String user_id, String seatnumber) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/seatbook.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("bus_name", CHAR_SET) + "=" + URLEncoder.encode(bus_name, CHAR_SET);
            data += "&" + URLEncoder.encode("user_id", CHAR_SET) + "=" + URLEncoder.encode(user_id, CHAR_SET);
            data += "&" + URLEncoder.encode("seatnumber", CHAR_SET) + "=" + URLEncoder.encode(seatnumber, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (UnsupportedEncodingException e) {
            response = response + e.getMessage();
            e.printStackTrace();

        } catch (IOException io) {
            response = response + io.getMessage();
        } finally {
            if (output != null) try {
                output.close();
            } catch (IOException ignoreIO) {
            }
        }


        return response;
    }
    // seat number nikal kar ek method se us array se match karwalege jisme total number of seat hai jo usme nhi wo unreserved hai.

    public static String recseats() {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/recseats.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception e) {
//          Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;

    }

    public static String passcreate(String user_id) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/passcreate.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "user_id=" + user_id;
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception e) {
//          Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;

    }

    public static String ticketcreate(String user_id) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/ticketcreate.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "user_id=" + user_id;
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception e) {
//          Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;

    }
    public static String verifyuser(String user_id) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/verifyuser.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "user_id=" + user_id;
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception e) {
//          Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

    public static String verifyticket(String user_id) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/verifyticket.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "user_id=" + user_id;
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception e) {
//          Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

    public static String checkpassstatus(String user_id) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/chkpastatus.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "user_id=" + user_id;
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception e) {
//          Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

    public static String getId(String email, String pass) {
        final String SERVER_URL = "http://192.168.43.2:81/buspasssystem/getId.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "email=" + email + "&pass=" + pass;
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception e) {
//          Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;

    }
}
