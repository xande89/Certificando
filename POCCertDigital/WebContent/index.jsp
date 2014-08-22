<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projeto Exemplo</title>
<style type="text/css">
table.padrao {
	background-color: #eeeeee;
}

td.padrao {
	font-family: "Arial";
	font-size: 12px;
}

input.padrao {
	font-family: "Arial";
	font-size: 14px;
	background-color: #F8F8F8;
	border: 1px solid #E8E8E8;
}
</style>
</head>
<script type="text/javascript">
	function foo() {
		alert("foo() method called!");
	}
</script>
<body>
	<form id="mainForm" name="mainForm" method="post"
		action="FileUploadServlet" >
		<table align="center" border="0" cellspacing="5" cellpadding="1"
			class="padrao">
			<tr>
				<td align="center"><applet
						codebase="http://localhost:8080/POCCertDigital/"
						code="br.gov.finep.assinadordigital.PanelArquivo"
						width="600" height="440" MAYSCRIPT
						archive="assinadorDigitalFinep-assinado.jar,						
							demoiselle-certificate-applet-1.0.8-assinado.jar,
							demoiselle-certificate-core-1.0.8-assinado.jar,
							demoiselle-certificate-criptography-1.0.8-assinado.jar,
							demoiselle-certificate-signer-1.0.8-assinado.jar,
							demoiselle-certificate-ca-icpbrasil-1.0.8-assinado.jar,
							demoiselle-certificate-ca-icpbrasil-homologacao-1.0.8-assinado.jar,
							bcmail-jdk15on-151-assinado.jar,
							bcprov-ext-jdk15on-151-assinado.jar,
							log4j-1.2.15-assinado.jar,
							slf4j-api-1.6.1-assinado.jar,
							slf4j-log4j12-1.6.1-assinado.jar,
							bcpkix-jdk15on-151-assinado.jar,
							java-plugin-1.6.0.23-assinado.jar">
						<param name="factory.applet.action"
							value="br.gov.finep.assinadordigital.Assinador"/>
						<param name="applet.javascript.postaction.failure" value="foo" />
					</applet>
				<td>
			</tr>
			<tr>
				<td>
					<table align="center" border="0" cellspacing="0" cellpadding="5"
						class="padrao">
						<tr>
							<td class="padrao">CPF:</td>
							<td><input class="padrao" type="text" name="cpf" value=""
								size="11"></td>
						</tr>
						<tr>
							<td class="padrao">Nome:</td>
							<td><input class="padrao" type="text" name="nome" value=""
								size="30"></td>
						</tr>
						<tr>
							<td class="padrao">Email:</td>
							<td><input class="padrao" type="text" name="email" value=""
								size="30"></td>
						</tr>
						<tr>
							<td class="padrao">Nascimento:</td>
							<td><input class="padrao" type="text" name="nascimento"
								value="" size="8"></td>
						</tr>
					</table>
			</tr>
		</table>
		
	</form>
</body>
</html>