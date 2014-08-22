package br.gov.finep.assinadordigital;

import java.applet.Applet;
import java.security.KeyStore;
import java.security.KeyStoreException;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.gov.frameworkdemoiselle.certificate.applet.action.AbstractAppletExecute;
import br.gov.frameworkdemoiselle.certificate.applet.certificate.ICPBrasilCertificate;

public class Assinador extends AbstractAppletExecute {

	private static final Logger logger = LoggerFactory
			.getLogger(Assinador.class);
	
	
	@Override
	public void execute(KeyStore keystore, String alias, int policyselected,
			Applet applet) {
		try {
			ICPBrasilCertificate certificado = super.getICPBrasilCertificate(
					keystore, alias, false);


			PanelArquivo dia = new PanelArquivo();

			dia.setCertificado(certificado);
			dia.setKeyStore(keystore);
			dia.pack();
			dia.setSize(400, 400);
			
			dia.setVisible(true);
			
			logger.error("executou");
			

		} catch (KeyStoreException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(applet, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void cancel(KeyStore keystore, String alias, int policyselected,
			Applet applet) {
		// TODO Auto-generated method stub

	}


}
