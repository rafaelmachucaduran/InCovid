package incovid.testPsicologico;

import incovid.notificaciones.enviar;

public class TestPsicologico{

	private int puntos;
	private int puntosTotales;
	private char p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20;
	private boolean error;
	// En el constructor inicializo las variables y se introducen las preguntas
	public TestPsicologico(){
		puntosTotales = 57;
		puntos = 0;
		error = false;
	}
	public char getP1() {
		return p1;
	}

	public void setP1(char p1) {
		this.p1 = p1;
	}

	public char getP2() {
		return p2;
	}

	public void setP2(char p2) {
		this.p2 = p2;
	}

	public char getP3() {
		return p3;
	}

	public void setP3(char p3) {
		this.p3 = p3;
	}

	public char getP4() {
		return p4;
	}

	public void setP4(char p4) {
		this.p4 = p4;
	}

	public char getP5() {
		return p5;
	}

	public void setP5(char p5) {
		this.p5 = p5;
	}

	public char getP6() {
		return p6;
	}

	public void setP6(char p6) {
		this.p6 = p6;
	}

	public char getP7() {
		return p7;
	}

	public void setP7(char p7) {
		this.p7 = p7;
	}

	public char getP8() {
		return p8;
	}

	public void setP8(char p8) {
		this.p8 = p8;
	}

	public char getP9() {
		return p9;
	}

	public void setP9(char p9) {
		this.p9 = p9;
	}

	public char getP10() {
		return p10;
	}

	public void setP10(char p10) {
		this.p10 = p10;
	}

	public char getP11() {
		return p11;
	}

	public void setP11(char p11) {
		this.p11 = p11;
	}

	public char getP12() {
		return p12;
	}

	public void setP12(char p12) {
		this.p12 = p12;
	}

	public char getP13() {
		return p13;
	}

	public void setP13(char p13) {
		this.p13 = p13;
	}

	public char getP14() {
		return p14;
	}

	public void setP14(char p14) {
		this.p14 = p14;
	}

	public char getP15() {
		return p15;
	}

	public void setP15(char p15) {
		this.p15 = p15;
	}

	public char getP16() {
		return p16;
	}

	public void setP16(char p16) {
		this.p16 = p16;
	}

	public char getP17() {
		return p17;
	}

	public void setP17(char p17) {
		this.p17 = p17;
	}

	public char getP18() {
		return p18;
	}

	public void setP18(char p18) {
		this.p18 = p18;
	}

	public char getP19() {
		return p19;
	}

	public void setP19(char p19) {
		this.p19 = p19;
	}

	public char getP20() {
		return p20;
	}

	public void setP20(char p20) {
		this.p20 = p20;
	}
	
	public int getPuntosTotales(){
		return puntosTotales;
	}

	public int calcularResultado(){
		if(p1 == 'a'){
			puntos += 3;
		}else if(p1 == 'b'){
			puntos += 0;
		}else if(p1 == 'c'){
			puntos += 2;
		}else if(p1 == 'd'){
			puntos += 1;
		}else{
			error = true;
		}
		if (!error) {
			if(p2 == 'a') {
				if (p3 == 'a') {
					puntos += 2;
				} else if (p3 == 'b') {
					puntos += 3;
				} else if (p3 == 'c') {
					puntos += 1;
				} else {
					error = true;
				}
			}else if(p2 == 'b'){
				puntosTotales -= 3;
			}else{
				error = true;
			}
		}
		if(!error){
			if(p4 == 'a'){
				puntos += 1;
			}else if(p4 == 'b'){
				puntos += 2;
			}else if(p4 == 'c'){
				puntos += 3;
			}else if(p4 == 'd'){
				puntos += 0;
			}else{
				error = true;
			}
		}
		if(!error){
			if(p5 == 'a'){
				puntos += 2;
			}else if(p5 == 'b'){
				puntos += 1;
			}else if(p5 == 'c'){
				puntos += 3;
			}else if(p5 == 'd'){
				puntos += 0;
			}else{
				error = true;
			}
		}
		if(!error){
			if(p6 == 'a'){
				puntos += 3;
			}else if(p6 == 'b'){
				puntos += 2;
			}else if(p6 == 'c'){
				puntos += 0;
			}else{
				error = true;
			}
		}
		if(!error){
			if(p7 == 'a'){
				puntos += 3;
			}else if(p7 == 'b'){
				puntos += 1;
			}else if(p7 == 'c'){
				puntos += 2;
			}else if(p7 == 'd'){
				puntos += 0;
			}else{
				error = true;
			}
		}
		if(!error){
			boolean entrarP9 = false;
			if(p8 == 'a'){
				puntos += 0;
				puntosTotales -= 3;
			}else if(p8 == 'b'){
				puntos += 3;
				entrarP9 = true;
			}else if(p8 == 'c'){
				puntos += 1;
				entrarP9 = true;
			}else if(p8 == 'd'){
				puntos += 2;
				entrarP9 = true;
			}else{
				error = true;
			}
			if(entrarP9){
				if(p9 == 'a'){
					puntos += 1;
				}else if(p9 == 'b'){
					puntos += 3;
				}else if(p9 == 'c') {
					puntos += 2;
				}else{
					error = true;
				}
			}
		}
		/**/
		if(!error){
			if(p10=='a'){
				puntos+=0;
			}else if(p10=='b'){
				puntos+=1;
			}else if(p10=='c'){
				puntos+=2;
			}else if(p10=='d'){
				puntos+=3;
			}else{
				error=true;
			}
		}
		if(!error){
			if(p11=='a'){
				puntos+=3;
			}else if(p11=='b'){
				puntos+=0;
			}else if(p11=='c'){
				puntos+=2;
			}else if(p11=='d'){
				puntos+=1;
			}else{
				error=true;
			}
		}
		if(!error){
			if(p12=='a'){
				puntos+=0;
			}else if(p12=='b'){
				puntos+=3;
			}else if(p12=='c'){
				puntos+=0;
			}else if(p12=='d'){
				puntos+=1;
			}else{
				error=true;
			}
		}
		if(!error){
			if(p13=='a'){
				puntos+=3;
			}else if(p13=='b'){
				puntos+=0;
			}else if(p13=='c'){
				puntos+=0;
			}else if(p13=='d'){
				puntos+=0;
			}else{
				error=true;
			}
		}
		if(!error){
			if(p14=='a'){
				puntos+=1;
			}else if(p14=='b'){
				puntos+=3;
			}else if(p14=='c'){
				puntos+=0;
			}else{
				error=true;
			}
		}
		if(!error){
			if(p15=='a'){
				puntos+=0;
			}else if(p15=='b'){
				puntos+=1;
			}else if(p15=='c'){
				puntos+=2;
			}else if(p15=='d'){
				puntos+=3;
			}else{
				error=true;
			}
		}
		/**/
		if(!error) {
			if (p16 == 'a') {
				puntos += 0;
			} else if (p16 == 'b') {
				puntos += 3;
			} else if (p16 == 'c') {
				puntos += 1;
			} else if (p16 == 'd') {
				puntos += 2;
			} else {
				error = true;
			}
		}
		if(!error) {
			if (p17 == 'a') {
				puntos += 1;
			} else if (p17 == 'b') {
				puntos += 2;
			} else if (p17 == 'c') {
				puntos += 3;
			} else {
				error = true;
			}
		}
		if(!error) {
			if (p18 == 'a') {
				puntos += 3;
			} else if (p18 == 'b') {
				puntos += 1;
			} else if (p18 == 'c') {
				puntos += 0;
			} else if (p18 == 'd') {
				puntos += 2;
			} else {
				error = true;
			}
		}
		if(!error) {
			if (p19 == 'a') {
				puntos += 0;
			} else if (p19 == 'b') {
				puntos += 2;
			} else if (p19 == 'c') {
				puntos += 3;
			} else {
				error = true;
			}
		}
		if(!error) {
			if (p20 == 'a') {
				puntos += 0;
			} else if (p20 == 'b') {
				puntos += 3;
			} else if (p20 == 'c') {
				puntos += 1;
			} else {
				error = true;
			}
		}
		if(error) puntos = -1;
		return puntos;
	}
	public void hacerEmail(int resultado, int ptosTotales, String correo){
		String res;
		if(resultado > ptosTotales - 5) {
			res="<!DOCTYPE html>\n" +
					"<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
					"<head th:insert=\"fragments.html :: headerfiles\"></head>\n" +
					"<body>\n" +
					"<header th:insert=\"fragments.html :: nav\"></header>\n" +
					"<!-- Page content goes here -->\n" +
					"<div class=\"container\">\n" +
					"  <h3 style=\"text-align: center; color: #3f7320;\">Usted necesita ayuda urgente</h3>\n" +
					"\n" +
					"  <p><img src=\"https://www.diariodesevilla.es/2019/03/04/salud/agobio-excesivo-cuestion-sintoma-ansiedad_1333376791_95974390_667x375.jpg\" alt=\"Covid\" width=\"300\" height=\"150\" style=\"display: block; margin-left: auto; margin-right: auto;\" /></p>\n" +
					"\n" +
					"  <p>Según los resultados del test que acaba de realizar usted necesita ayuda psicológica urgente, por lo tanto le recomendamos que acuda al psicólogo, además de revisar los enlaces de aquí abajo.</p>\n" +
					"\n" +
					"  <h3 style=\"text-align: center; color: #3f7320;\">Enlaces de ayuda:</h3>\n" +
					"\n" +
					"  <p><a href=\"https://www.20minutos.es/noticia/4188339/0/ayuda-psicologica-gratuita-para-mitigar-la-ansiedad-y-la-angustia-que-provoca-el-coronavirus/\" target=\"_blank\" rel=\"noopener\">https://www.20minutos.es/noticia/4188339/0/ayuda-psicologica-gratuita-para-mitigar-la-ansiedad-y-la-angustia-que-provoca-el-coronavirus/</a>&nbsp;</p>\n" +
					"  <p><a href=\"https://ifeelonline.com/\" target=\"_blank\" rel=\"noopener\">https://ifeelonline.com/</a></p>\n" +
					"  <p><a href=\"https://therapychat.com/es-es/\" target=\"_blank\" rel=\"noopener\">https://therapychat.com/es-es/</a></p>\n" +
					"  <p><a href=\"https://serenmind.com/\" target=\"_blank\" rel=\"noopener\">https://serenmind.com/</a></p>\n" +
					"  <p><a href=\"https://www.psonrie.com/\" target=\"_blank\" rel=\"noopener\">https://www.psonrie.com/</a></p>\n" +
					"  <p><a href=\"https://www.docplanner.com/about-us\" target=\"_blank\" rel=\"noopener\">https://www.docplanner.com/about-us</a></p>\n" +
					"  <p><a href=\"https://www.copmadrid.org/web/files/comunicacion/Orientaciones_para_la_gestion_psicologica_de_la_cuarentena_por_el_Coronavirus.pdf\" target=\"_blank\" rel=\"noopener\">https://www.copmadrid.org/web/files/comunicacion/Orientaciones_para_la_gestion_psicologica_de_la_cuarentena_por_el_Coronavirus.pdf</a></p>\n" +
					"  <p><a href=\"https://www.cop.es/index.php\" target=\"_blank\" rel=\"noopener\">https://www.cop.es/index.php</a></p>\n" +
					"  <p><a href=\"https://www.psicologos-malaga.com/psicologo-online/?gclid=CjwKCAjwy42FBhB2EiwAJY0yQrKIRFThPrPxuffCVlvnOB9ggw3kcISv-2ZFIe-oONmTp5wKIvmXVhoCt-oQAvD_BwE\" target=\"_blank\" rel=\"noopener\">https://www.psicologos-malaga.com/psicologo-online/?gclid=CjwKCAjwy42FBhB2EiwAJY0yQrKIRFThPrPxuffCVlvnOB9ggw3kcISv-2ZFIe-oONmTp5wKIvmXVhoCt-oQAvD_BwE</a></p>" +
					"\n" +
					"</div>\n" +
					"\n" +
					"\n" +
					"\n" +
					"</body>\n" +
					"</html>";
			Thread t1 = new Thread(() -> new enviar().enviarCorreo(res, correo));
			t1.start();
		}else if(resultado > ptosTotales - 12) {
			res="<!DOCTYPE html>\n" +
					"<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
					"<head th:insert=\"fragments.html :: headerfiles\"></head>\n" +
					"<body>\n" +
					"<header th:insert=\"fragments.html :: nav\"></header>\n" +
					"<div class=\"container\">\n" +
					"  <h3 style=\"text-align: center; color: #3f7320;\">Usted necesita ayuda seria</h3>\n" +
					"\n" +
					"  <p><img src=\"https://www.diariodesevilla.es/2019/03/04/salud/personas-ansiedad-obcecacion-cuestion-concreta_1333376795_95974557_667x375.jpg\" alt=\"Covid\" width=\"300\" height=\"150\" style=\"display: block; margin-left: auto; margin-right: auto;\" /></p>\n" +
					"\n" +
					"  <p>Según los resultados del test psicológico usted necesita ayuda ya que se encuentra en una situación grave psicológicamente. Le ofrecemos abajo páginas de ayuda para que obtenga consejo.</p>\n" +
					"\n" +
					"  <h3 style=\"text-align: center; color: #3f7320;\">Enlaces de ayuda:</h3>\n" +
					"\n" +
					"  <p><a href=\"https://www.ine.es/covid/covid_inicio.htm\" target=\"_blank\" rel=\"noopener\">https://www.ine.es/covid/covid_inicio.htm</a>&nbsp;</p>\n" +
					"  <p><a href=\"https://www.mscbs.gob.es/profesionales/saludPublica/ccayes/alertasActual/nCov/situacionActual.htm\" target=\"_blank\" rel=\"noopener\">https://www.mscbs.gob.es/profesionales/saludPublica/ccayes/alertasActual/nCov/situacionActual.htm</a>&nbsp;</p>\n" +
					"  <p><a href=\"https://www.who.int/es/news-room/fact-sheets/detail/middle-east-respiratory-syndrome-coronavirus-(mers-cov)\" target=\"_blank\" rel=\"noopener\">https://www.who.int/es/news-room/fact-sheets/detail/middle-east-respiratory-syndrome-coronavirus-(mers-cov)</a>&nbsp;</p>\n" +
					"  <p><a href=\"https://covid19.who.int/\" target=\"_blank\" rel=\"noopener\">https://covid19.who.int/</a>&nbsp;</p>\n" +
					"  <p><a href=\"https://www.who.int/emergencies/diseases/novel-coronavirus-2019/situation-reports\" target=\"_blank\" rel=\"noopener\">https://www.who.int/emergencies/diseases/novel-coronavirus-2019/situation-reports</a>&nbsp;</p>\n" +
					"</div>\n" +
					"</body>\n" +
					"</html>";
			Thread t1 = new Thread(() -> new enviar().enviarCorreo(res, correo));
			t1.start();
		}else if(resultado > ptosTotales - 27) {
			res="<!DOCTYPE html>\n" +
					"<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
					"<head th:insert=\"fragments.html :: headerfiles\"></head>\n" +
					"<body>\n" +
					"<header th:insert=\"fragments.html :: nav\"></header>\n" +
					"<!-- Page content goes here -->\n" +
					"<div class=\"container\">\n" +
					"  <h3 style=\"text-align: center; color: #3f7320;\">Usted necesita ayuda</h3>\n" +
					"  <p><img src=\"https://i.pinimg.com/originals/80/5e/ac/805eac01b52310622eb8d70976a0bbba.jpg\" alt=\"Covid\" width=\"300\" height=\"150\" style=\"display: block; margin-left: auto; margin-right: auto;\" /></p>\n" +
					"\n" +
					"  <p>Según los resultados obtenidos en el test, le recomendamos los enlaces de ayuda, aunque a usted no le ha afectado la pademia de forma tan drástica.</p>\n" +
					"\n" +
					"  <h3 style=\"text-align: center; color: #3f7320;\">Enlaces de ayuda:</h3>\n" +
					"\n" +
					"  <p><a href=\"https://www.20minutos.es/noticia/4188339/0/ayuda-psicologica-gratuita-para-mitigar-la-ansiedad-y-la-angustia-que-provoca-el-coronavirus/\" target=\"_blank\" rel=\"noopener\">https://www.20minutos.es/noticia/4188339/0/ayuda-psicologica-gratuita-para-mitigar-la-ansiedad-y-la-angustia-que-provoca-el-coronavirus/</a>&nbsp;</p>\n" +
					"  <p><a href=\"https://ifeelonline.com/\" target=\"_blank\" rel=\"noopener\">https://ifeelonline.com/</a></p>\n" +
					"  <p><a href=\"https://www.copmadrid.org/web/files/comunicacion/Orientaciones_para_la_gestion_psicologica_de_la_cuarentena_por_el_Coronavirus.pdf\" target=\"_blank\" rel=\"noopener\">https://www.copmadrid.org/web/files/comunicacion/Orientaciones_para_la_gestion_psicologica_de_la_cuarentena_por_el_Coronavirus.pdf</a></p>\n" +
					"  <p><a href=\"https://www.cop.es/index.php\" target=\"_blank\" rel=\"noopener\">https://www.cop.es/index.php</a></p>" +
					"\n" +
					"</div>\n" +
					"\n" +
					"\n" +
					"\n" +
					"</body>\n" +
					"</html>";
			Thread t1 = new Thread(() -> new enviar().enviarCorreo(res, correo));
			t1.start();
		}else if(resultado > ptosTotales - 42) {
			res="<!DOCTYPE html>\n" +
					"<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
					"<head th:insert=\"fragments.html :: headerfiles\"></head>\n" +
					"<body>\n" +
					"<header th:insert=\"fragments.html :: nav\"></header>\n" +
					"<div class=\"container\">\n" +
					"  <h3 style=\"text-align: center; color: #3f7320;\">A usted no le ha afectado tanto la pandemia</h3>\n" +
					"\n" +
					"<p><img src=\"https://www.familias.com/wp-content/uploads/2015/01/featuredImageId63020-700x487.jpg\" alt=\"Covid\" width=\"300\" height=\"150\" style=\"display: block; margin-left: auto; margin-right: auto;\" /></p>\n" +
					"\n" +
					"  <p>Según los resultados que hemos obtenidos del test, usted no necesita demasiada ayuda ya que no le ha afectado tanto la pandemia.\n" +
					"    Igualmente vamos a proporcionarle unos enlaces de ayuda por si los necesitas</p>\n" +
					"\n" +
					"  <h3 style=\"text-align: center; color: #3f7320;\">Enlaces de ayuda:</h3>\n" +
					"\n" +
					"  <p><a href=\"https://www.20minutos.es/noticia/4188339/0/ayuda-psicologica-gratuita-para-mitigar-la-ansiedad-y-la-angustia-que-provoca-el-coronavirus/\" target=\"_blank\" rel=\"noopener\">https://www.20minutos.es/noticia/4188339/0/ayuda-psicologica-gratuita-para-mitigar-la-ansiedad-y-la-angustia-que-provoca-el-coronavirus/</a>&nbsp;</p>\n" +
					"  <p><a href=\"https://www.copmadrid.org/web/files/comunicacion/Orientaciones_para_la_gestion_psicologica_de_la_cuarentena_por_el_Coronavirus.pdf\" target=\"_blank\" rel=\"noopener\">https://www.copmadrid.org/web/files/comunicacion/Orientaciones_para_la_gestion_psicologica_de_la_cuarentena_por_el_Coronavirus.pdf</a></p>\n" +
					"  <p><a href=\"https://www.cop.es/index.php\" target=\"_blank\" rel=\"noopener\">https://www.cop.es/index.php</a></p>" +
					"\n" +
					"</div>\n" +
					"\n" +
					"\n" +
					"\n" +
					"</body>\n" +
					"</html>";
			Thread t1 = new Thread(() -> new enviar().enviarCorreo(res, correo));
			t1.start();
		} else {
			res="<!DOCTYPE html>\n" +
					"<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
					"<head th:insert=\"fragments.html :: headerfiles\"></head>\n" +
					"<body>\n" +
					"<header th:insert=\"fragments.html :: nav\"></header>\n" +
					"<div class=\"container\">\n" +
					"  <h3 style=\"text-align: center; color: #3f7320;\">Usted está correctamente</h3>\n" +
					"\n" +
					"  <p><img src=\"https://static.vix.com/es/sites/default/files/styles/4x3/public/imj/imujer/G/GenteFeliz.jpg\" alt=\"Covid\" width=\"300\" height=\"150\" style=\"display: block; margin-left: auto; margin-right: auto;\" /></p>\n" +
					"\n" +
					"  <p>Según los resultados del test usted no necesita ayuda ya que su estado psicológico no ha sido afectado por la pandemia. Si aun así necesita ayuda contactenos.</p>\n" +
					"</div>\n" +
					"</body>\n" +
					"</html>";
			Thread t1 = new Thread(() -> new enviar().enviarCorreo(res, correo));
			t1.start();
		}
	}
}