package br.gov.finep.assinadordigital;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.gov.frameworkdemoiselle.certificate.applet.certificate.ICPBrasilCertificate;
import br.gov.frameworkdemoiselle.certificate.signer.SignerAlgorithmEnum;
import br.gov.frameworkdemoiselle.certificate.signer.factory.PKCS1Factory;
import br.gov.frameworkdemoiselle.certificate.signer.pkcs1.PKCS1Signer;

public class PanelArquivo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4212678257273190763L;
	private static final Logger logger = LoggerFactory
			.getLogger(PanelArquivo.class);

	private File arquivoSelecionado;
	JLabel nomeArquivoSelecionado;
	private ICPBrasilCertificate certificado;
	private KeyStore keystore;

	public PanelArquivo() {
		// super();
		logger.debug("executou construtor novo");
		adicionaConteudo();
	}

	public void adicionaConteudo() {

		defineVisual();
		getContentPane().setLayout(null);
		getContentPane().setSize(400, 400);
		getContentPane().setBackground(Color.WHITE);

		JButton botao = new JButton("Escolher arquivo");
		botao.setLocation(10, 10);
		botao.setSize(120, 25);
		this.getContentPane().add(botao);
		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fcChooser = new JFileChooser();
				fcChooser.showOpenDialog(fcChooser);
				arquivoSelecionado = fcChooser.getSelectedFile();

				logger.debug(arquivoSelecionado.getName());

				if (arquivoSelecionado != null) {

					nomeArquivoSelecionado.setText(arquivoSelecionado.getName());

				}
			}
		});

		JLabel labelArquivoSelecionado = new JLabel("Arquivo: ");
		labelArquivoSelecionado.setLocation(10, 50);
		labelArquivoSelecionado.setSize(80, 20);
		this.getContentPane().add(labelArquivoSelecionado);

		nomeArquivoSelecionado = new JLabel("...");
		nomeArquivoSelecionado.setLocation(60, 50);
		nomeArquivoSelecionado.setSize(80, 20);
		this.getContentPane().add(nomeArquivoSelecionado);

		JButton botaoAssinarArquivo = new JButton("Assinar arquivo");
		botaoAssinarArquivo.setLocation(10, 100);
		botaoAssinarArquivo.setSize(120, 25);
		this.getContentPane().add(botaoAssinarArquivo);
		botaoAssinarArquivo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/* conteudo a ser assinado */

				// arquivoSelecionado.
				
				 byte[] content = getByteArrayArquivo(arquivoSelecionado);
				 /* chave privada */
				 PrivateKey chavePrivada = getPrivateKeyDoCertificado(); /* implementar
				 metodo para pegar chave privada */
				 /* construindo um objeto PKCS1Signer atraves da fabrica */
				 PKCS1Signer signer = PKCS1Factory.getInstance().factory();
				 /* Configurando o algoritmo */
				 signer.setAlgorithm(SignerAlgorithmEnum.SHA1withRSA);
				 /* Configurando a chave privada */
				 signer.setPrivateKey(chavePrivada);
				 /* Assinando um conjunto de bytes */
				 byte[] sign = signer.doSign(content);
				 
				 logger.debug(new String(sign));
			}

		});

		JButton botaoEnviarArquivo = new JButton("Enviar arquivo");
		botaoEnviarArquivo.setLocation(150, 100);
		botaoEnviarArquivo.setSize(120, 25);
		this.getContentPane().add(botaoEnviarArquivo);
		botaoEnviarArquivo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mandaArquivoServidor();
			}
		});

		JLabel resultadoLabel = new JLabel("...");
		resultadoLabel.setLocation(10, 130);
		resultadoLabel.setSize(300, 20);
		this.getContentPane().add(resultadoLabel);

		// requestFocusInWindow();
		logger.debug("adiciona label");

	}

	private PrivateKey getPrivateKeyDoCertificado(){
			
		PrivateKey chavePrivada =null;
		
		
		try {
			keystore.setCertificateEntry("certPessoal", keystore.getCertificate("certPessoal"));
			
			
			chavePrivada = (PrivateKey) this.keystore.getKey("certPessoal", "changeit".toCharArray());
		} 
		catch (KeyStoreException e) {
			logger.error("Não foi possível obter a keystore carregada");
		}
		catch (UnrecoverableKeyException e) {
			logger.error("Não foi possível obter a a chave privada do certificado");
		}
		catch (NoSuchAlgorithmException e) {
			logger.error("Não foi possível obter o algoritmo");
		}
		
		return chavePrivada;
	}

	private void defineVisual() {
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	private byte[] getByteArrayArquivo(File arq) {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		FileInputStream in;

		try 
		{
			in = new FileInputStream(arq);

			int b;
			while ((b = in.read()) > -1) {
				out.write(b);
			}
			out.close();
			in.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		return out.toByteArray();
	}

	public void mandaArquivoServidor() {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL("http://localhost:8080/POCCertDigital/UploadArquivo");

			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection
					.setRequestProperty("Content-Type", "multipart/form-data");
			connection.setRequestMethod("POST");

			connection.setRequestProperty("arquivo",
					arquivoSelecionado.getName());

			OutputStream out = connection.getOutputStream();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			byte[] imageInByte = baos.toByteArray();

			out.write(imageInByte, 0, imageInByte.length);
			out.flush();
			out.close();
			int requestCode = connection.getResponseCode();
			if (requestCode != 200) {
				throw new Exception("Erro ao salvar a imagem Code: "
						+ requestCode + "Message: "
						+ connection.getResponseMessage());
			}
		} catch (Exception e1) {
			logger.error(e1.getMessage()
					+ (e1.getCause() != null ? "Cause: "
							+ e1.getCause().getMessage() : ""));
		} finally {
			if (connection != null)
				connection.disconnect();
		}

	}

	public ICPBrasilCertificate getCertificado() {
		return certificado;
	}

	public void setCertificado(ICPBrasilCertificate certificado) {
		this.certificado = certificado;
	}

	public void setKeyStore(KeyStore keystore) {
		this.keystore = keystore;
	}
	public KeyStore getKeyStore() {
		return keystore;
	}

}
