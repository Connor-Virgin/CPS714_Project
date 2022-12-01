package webApp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import objects.Appointment;
import objects.Doctor;
import objects.Patient;
import webApp.models.Appt;
import webApp.models.SessionUser;
import webApp.models.DisplayAppoint;
import webApp.services.AdminService;

@Controller
@SessionAttributes({ "sessionUser" })
public class AdminController {

    // Used to keep sessionUser info on page even when reloaded
    @ModelAttribute("sessionUser")
    public SessionUser sessionUser() {
        return new SessionUser();
    }

    // Instance Variables
    private AdminService adminService;

    // Constructor (needed for Spring to use the AdminService)
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Deals with the HTML get request '/admin'
    @GetMapping("/admin")
    public String main(Model model, SessionUser sessionUser, Appt appt) {
        // repopulates doctor list
        List<Doctor> allDoctors = adminService.getAllDoctors();
        model.addAttribute("allDoctors", allDoctors);

        // Thymeleaf looks for admin.html in resources/templates/
        return "admin";
    }

    @GetMapping("/admin/wards")
    public String wards(Model model, SessionUser sessionUser) {
        model.addAttribute("wards", true);
        // Thymeleaf looks for admin.html in resources/templates/
        return "admin";
    }

    @PostMapping("/admin/wards/ward")
    public String ward(Model model, SessionUser sessionUser, @RequestParam("ward") int ward) {

        List<Patient> patients = adminService.getWardPatients(ward);
        model.addAttribute("patients", patients);

        List<Integer> rooms = adminService.getAvailableRooms(ward);
        model.addAttribute("rooms", rooms);

        // System.out.println(patients);
        model.addAttribute("wards", true);
        return "admin";
    }

    // Deals with the HTML post request mapped to '/doctorEditAppt'
    @PostMapping("/admin/wards/ward/update")
    public String doctorEditAppt(Model model, SessionUser sessionUser, @RequestParam("patientID") int patientID,
            @RequestParam("ward") int ward, @RequestParam("room") int room,
            @RequestParam("currentWard") int currentWard) {

        if (adminService.updateWard(patientID, ward, room)) {
            model.addAttribute("message", "Ward Updated!");
            List<Patient> patients = adminService.getWardPatients(currentWard);
            model.addAttribute("patients", patients);
            List<Integer> rooms = adminService.getAvailableRooms(currentWard);
            model.addAttribute("rooms", rooms);
            model.addAttribute("wards", true);
            return "admin";
        }
        model.addAttribute("message", "Ward Not Updated!");
        List<Patient> patients = adminService.getWardPatients(currentWard);
        List<Integer> rooms = adminService.getAvailableRooms(currentWard);
        model.addAttribute("rooms", rooms);
        model.addAttribute("patients", patients);
        model.addAttribute("wards", true);
        return "admin";
    }

    @PostMapping("/getAppointsAdmin")
    public String getAvailableAppts(Model model, SessionUser sessionUser, Appt appt) {

        // System.out.println("Test " + appt.getDoctor_id());

        // Use services to return the list of appointments by doctor
        List<Appointment> appointments = adminService.displayAppointmentsByDoctor(appt);
        model.addAttribute("appointments", appointments);

        // repopulates doctor list
        List<Doctor> allDoctors = adminService.getAllDoctors();
        model.addAttribute("allDoctors", allDoctors);

        DisplayAppoint displayAppoint = new DisplayAppoint();
        model.addAttribute("displayAppoint", displayAppoint);

        // refreshes page, now with appointments added
        return "admin";
    }

    @GetMapping("/deleteAppointsAdmin/{id}")
    public String deleteAppt(@PathVariable int id) {
        adminService.deleteAppt(id);
        return "redirect:/admin";
    }

    /*
     * @PostMapping("/deleteAppointsAdmin")
     * public String deleteAppt(Model model, SessionUser sessionUser, DisplayAppoint
     * displayAppoint, Appt appt){
     * 
     * System.out.println("displayAppoint id: " +
     * displayAppoint.getAppointment_id());
     * 
     * //Attempts to deleted selected appointment
     * if(adminService.deleteAppt(displayAppoint.getAppointment_id())){
     * //Pass a string called message to be dispayed
     * model.addAttribute("message", "Success: Appointment Deleted");
     * }
     * else{
     * //Pass a string called message to be dispayed
     * model.addAttribute("message", "Error: Appointment not Deleted");
     * }
     * //repopulates doctor list
     * List<Doctor> allDoctors = adminService.getAllDoctors();
     * model.addAttribute("allDoctors", allDoctors);
     * 
     * //refreshes page
     * return "admin";
     * }
     */

}
