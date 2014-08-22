package br.gov.finep.assinadordigital.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.gov.finep.assinadordigital.PanelArquivo;

public class EventoFileChooser implements ActionListener {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PanelArquivo.class);
	private JFileChooser fc;

	public EventoFileChooser(JFileChooser fc){
		this.fc = fc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		
//		int returnVal =e.getID();
//		
//		if (returnVal == JFileChooser.APPROVE_OPTION) {
//            File file = fc.getSelectedFile();
//            //This is where a real application would open the file.
//            logger.debug("Opening: " + file.getName() + ".");
//        } else {
//        	logger.debug("Open command cancelled by user." );
//        }
	}

}
