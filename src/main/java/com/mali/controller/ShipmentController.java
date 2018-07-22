package com.mali.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mali.interfaces.ProcessInterface;
import com.mali.model.BillOfLading;
import com.mali.model.CCVO;
import com.mali.model.CRIA;
import com.mali.model.Delivery;
import com.mali.model.COA;
import com.mali.model.FormM;
import com.mali.model.ManufacturerCertificate;
import com.mali.model.PackingList;
import com.mali.model.Project;
import com.mali.model.Reciept;
import com.mali.model.Remark;

@Controller
public class ShipmentController {

	@Value("${profile.uploadedfile.path}")
	String filePath;

	ProcessInterface processInterface;

	public ShipmentController(ProcessInterface processInterface) {
		this.processInterface = processInterface;
	}

	@PostMapping(value = "/saveProjectBol")
	public String saveProjectBol(Model model, BillOfLading bol, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(bol.getProjectId());
		bol.setProject(project);
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dateStr = bol.getDepartureDateStr();
			bol.setDepartureDate(LocalDate.parse(dateStr, formatter));
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				bol.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveBol(bol);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectCcvo")
	public String saveProjectCcvo(Model model, CCVO ccvo, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(ccvo.getProjectId());
		ccvo.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				ccvo.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveCcvo(ccvo);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectCfia")
	public String saveProjectCfia(Model model, CRIA cfia, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(cfia.getProjectId());
		cfia.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				cfia.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveCFIA(cfia);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectCoa")
	public String saveProjectCoa(Model model, COA coa, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(coa.getProjectId());
		coa.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				coa.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveCOA(coa);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectFormM")
	public String saveProjectFormM(Model model, FormM formM, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(formM.getProjectId());
		formM.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				// formM.setFileName("files/" + file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveFormM(formM);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectManufacturerCertificate")
	public String saveProjectManufacturerCertificate(Model model, ManufacturerCertificate mc,
			@RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(mc.getProjectId());
		mc.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				mc.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveManufacturerCertificate(mc);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectPackingList")
	public String saveProjectPackingList(Model model, PackingList pl, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(pl.getProjectId());
		pl.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				pl.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.savePackingList(pl);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectDelivery")
	public String saveProjectDelivery(Model model, Delivery delivery, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(delivery.getProjectId());
		delivery.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				delivery.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveDelivery(delivery);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectReciept")
	public String saveProjectReciept(Model model, Reciept reciept, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(reciept.getProjectId());
		reciept.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				reciept.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveReciept(reciept);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectRemark")
	public String saveProjectRemark(Model model, Remark remark, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(remark.getProjectId());
		remark.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				// remark.setFileName("files/" + file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveRemark(remark);
		model.addAttribute("project", project);
		return "project";
	}
}
