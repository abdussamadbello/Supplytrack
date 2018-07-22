package com.mali.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mali.interfaces.ProcessInterface;
import com.mali.model.Insurance;
import com.mali.model.LetterOfCredit;
import com.mali.model.ProformalInvoice;
import com.mali.model.Project;
import com.mali.model.Regulatory;

@Controller
public class ProjectController {

	@Value("${profile.uploadedfile.path}")
	String filePath;

	ProcessInterface processInterface;

	public ProjectController(ProcessInterface processInterface) {
		this.processInterface = processInterface;
	}

	@GetMapping(value = "/displayProjectFlow")
	public String displayProjectFlow(Model model, @RequestParam Long projectId) {
		Project project = processInterface.findProjectById(projectId);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectInsurance")
	public String saveProjectInsurance(Model model, Insurance insurance, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(insurance.getProjectId());
		insurance.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				insurance.setFileName(file1.getOriginalFilename());
			}
			processInterface.saveInsurance(insurance);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectPfi")
	public String saveProjectPfi(Model model, ProformalInvoice pfi, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(pfi.getProjectId());
		System.out.println("calling saveProjectPfi");
		pfi.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				pfi.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveProformalInvoice(pfi);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectLoc")
	public String saveProjectLoc(Model model, LetterOfCredit loc, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(loc.getProjectId());
		loc.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				loc.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveLetterOfCredit(loc);
		model.addAttribute("project", project);
		return "project";
	}

	@PostMapping(value = "/saveProjectReg")
	public String saveProjectReg(Model model, Regulatory reg, @RequestParam("picture") MultipartFile file1) {
		Project project = processInterface.findProjectById(reg.getProjectId());
		reg.setProject(project);
		try {
			byte[] bytes = file1.getBytes();
			Path path = Paths.get(filePath + file1.getOriginalFilename());
			System.out.println("file1.getOriginalFilename()===" + file1.getOriginalFilename());
			if (!Strings.isNullOrEmpty(file1.getOriginalFilename())) {
				Files.write(path, bytes);
				// log.info(file1.getOriginalFilename());
				reg.setFileName(file1.getOriginalFilename());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		processInterface.saveRegulatory(reg);
		model.addAttribute("project", project);
		return "project";
	}
}
