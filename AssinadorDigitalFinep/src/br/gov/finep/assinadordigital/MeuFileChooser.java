package br.gov.finep.assinadordigital;

import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicDirectoryModel;

import sun.swing.FilePane.FileChooserUIAccessor;

public class MeuFileChooser implements FileChooserUIAccessor {

	@Override
	public JPanel createDetailsView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MouseListener createDoubleClickListener(JList arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPanel createList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListSelectionListener createListSelectionListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action getApproveSelectionAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action getChangeToParentDirectoryAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JFileChooser getFileChooser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicDirectoryModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action getNewFolderAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDirectorySelected() {
		// TODO Auto-generated method stub
		return false;
	}

}
