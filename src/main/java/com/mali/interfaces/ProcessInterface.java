package com.mali.interfaces;

import java.util.List;

import com.mali.model.BillOfLading;
import com.mali.model.CCVO;
import com.mali.model.CRIA;
import com.mali.model.Delivery;
import com.mali.model.COA;
import com.mali.model.FormM;
import com.mali.model.Insurance;
import com.mali.model.LetterOfCredit;
import com.mali.model.ManufacturerCertificate;
import com.mali.model.PackingList;
import com.mali.model.ProformalInvoice;
import com.mali.model.Project;
import com.mali.model.Reciept;
import com.mali.model.Regulatory;
import com.mali.model.Remark;

public interface ProcessInterface {

	public Project saveProject(Project project);

	public List<Project> findProjects();

	public void deleteProject(Project project);

	public Project findProjectById(Long id);

	public Insurance saveInsurance(Insurance ins);

	public LetterOfCredit saveLetterOfCredit(LetterOfCredit loc);

	public ProformalInvoice saveProformalInvoice(ProformalInvoice pfi);

	public Regulatory saveRegulatory(Regulatory reg);

	public BillOfLading saveBol(BillOfLading bol);

	public CCVO saveCcvo(CCVO ccvo);

	public CRIA saveCFIA(CRIA cfia);

	public COA saveCOA(COA coa);

	public FormM saveFormM(FormM formM);

	public ManufacturerCertificate saveManufacturerCertificate(ManufacturerCertificate mc);

	public PackingList savePackingList(PackingList pl);

	public Delivery saveDelivery(Delivery delivery);

	public Reciept saveReciept(Reciept reciept);

	public Remark saveRemark(Remark remark);

}
