package susparaconcursos.mxtechnologies.com.susparaconcursos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Moisés on 10/02/2016.
 */
public class SUS20 extends Fragment {
    private TextView questaoTextView;
    private TextView textView;
    private RadioButton a;
    private RadioButton b;
    private RadioButton c;
    private RadioButton d;
    private RadioButton e;
    private RadioGroup rg;
    private int opcao;
    private int tentativas;
    private int alternativa;
    int[] nquestion;
    int nquestions;
    int m;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.content_sus,container,false);



        nquestions = 239;
        m=0;
        tentativas=0;
        textView = (TextView) view.findViewById(R.id.textView);
        questaoTextView = (TextView) view.findViewById(R.id.questaoTextView);
        rg = (RadioGroup)view.findViewById(R.id.rgopcoes);
        a = (RadioButton)view.findViewById(R.id.a);
        b = (RadioButton)view.findViewById(R.id.b);
        c = (RadioButton)view.findViewById(R.id.c);
        d = (RadioButton)view.findViewById(R.id.d);
        e = (RadioButton)view.findViewById(R.id.e);
        nquestion = new int[20];
        int tquestions [];
        int aux;
        Random random  = new Random();
        tquestions = new int[nquestions];
        for(int b=0;b<nquestions;b++){
            tquestions[b]=b+1;
        }
        for (int n=0;n<20;n++){
            do{
                aux=random.nextInt(nquestions);
                nquestion[n]=tquestions[aux];
            }while(tquestions[aux]==0);
            tquestions[aux]=0;
        }

        alternativa=update(nquestion[m]);
        textView.setText((m + 1) + " de "+nquestion.length);

        Button button1 = (Button)view.findViewById(R.id.button1);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        opcao = rg.getCheckedRadioButtonId();
                        alternativa = update(nquestion[m]);
                        textView.setText((m + 1) + " de "+nquestion.length);
                        if (opcao != alternativa) {
                            tentativas = tentativas + 1;
                            AlertDialog.Builder mensagem = new AlertDialog.Builder(getActivity());
                            mensagem.setTitle("Atenção!");
                            mensagem.setMessage("Alternativa incorreta");
                            mensagem.setNeutralButton("OK", null);
                            mensagem.show();
                        }

                        if (opcao == alternativa) {
                            if (m == (nquestion.length-1)) {
                                tentativas = tentativas + 1;
                                AlertDialog.Builder mensagem1 = new AlertDialog.Builder(getActivity());
                                mensagem1.setTitle("   ESTATÍSTICAS");
                                mensagem1.setMessage(tentativas + " tentativas para responder " + nquestion.length + " questões");
                                mensagem1.setNeutralButton("Finalizar", null);
                                mensagem1.show();
                            }

                            if (m < (nquestion.length-1)) {
                                tentativas = tentativas + 1;
                                AlertDialog.Builder mensagem = new AlertDialog.Builder(getActivity());
                                mensagem.setTitle("Parabéns!");
                                mensagem.setMessage("Alternativa correta");
                                mensagem.setNeutralButton("OK", null);
                                mensagem.show();
                                m = m + 1;
                                alternativa = update(nquestion[m]);
                                textView.setText((m + 1) + " de " + nquestion.length);
                            }
                        }
                    }
                });
        Button button2 = (Button)view.findViewById(R.id.button2);
        button2.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        if(m>0) {
                            m = m - 1;
                            alternativa = update(nquestion[m]);
                            textView.setText((m + 1) + " de "+nquestion.length);
                        }else{
                            Toast.makeText(getActivity(), "Início do Teste", Toast.LENGTH_SHORT).show();

                        }
                    }

                });


        return view;
    }

    private int update(int question) {
        int alt = -1;
        if (question == 0) {
            questaoTextView.setText("Aos _______________ de entidade ou serviços contratados é vedado exercer cargo de chefia ou função de confiança no SUS. ");
            a.setText("proprietários");
            b.setText("administrados");
            c.setText("dirigentes");
            d.setText("dirigentes");
            e.setText("todas as alternativas estão corretas");
            alt = R.id.e;
        }
        if (question == 1) {
            questaoTextView.setText("A direção do SUS é exercida no âmbito da União pelo(a): ");
            a.setText("Presidente da República");
            b.setText("Ministério da Saúde");
            c.setText("Ministério da Previdência Social");
            d.setText("Presidente da F.N.S");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 2) {
            questaoTextView.setText("A direção do SUS é exercida no âmbito dos Município, pelo(a): ");
            a.setText("União");
            b.setText("Ministro da Saúde");
            c.setText("pela respectiva Secretaria de Saúde ou órgão equivalente");
            d.setText("Presidente da República");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 3) {
            questaoTextView.setText("Sobre a direção do SUS podemos afirmar: ");
            a.setText("é exercida, exclusivamente, pelos Municípios.");
            b.setText("é única");
            c.setText("é regionalizada");
            d.setText("é exercida somente pelos estados");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 4) {
            questaoTextView.setText("De acordo com a lei 8.080/90, a saúde é __________ do ser humano. ");
            a.setText("direito");
            b.setText("dever");
            c.setText("faculdade");
            d.setText("garantia");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 5) {
            questaoTextView.setText("O dever do Estado no que diz respeito à saúde exclui o: ");
            a.setText("das pessoas");
            b.setText("da família");
            c.setText("das empresas");
            d.setText("da sociedade");
            e.setText("N.D.A");
            alt = R.id.e;
        }
        if (question == 6) {
            questaoTextView.setText("O dever do Estado de garantir a saúde consiste na formulação e execução de políticas: ");
            a.setText("internacionais e nacionais");
            b.setText("administrativas e revolucionárias");
            c.setText("econômicas e sociais");
            d.setText("únicas e universais");
            e.setText("públicas");
            alt = R.id.c;
        }
        if (question == 7) {
            questaoTextView.setText("São fatores determinantes e condicionantes da saúde: ");
            a.setText("alimentação e a organização econômica do País");
            b.setText("a moradia e o acesso aos bens e serviços essenciais");
            c.setText("o saneamento básico e o desenvolvimento urbano");
            d.setText("o meio ambiente e a organização industrial nacional");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 8) {
            questaoTextView.setText("Segundo a NOB/96 do Ministério da Saúde, “um montante que corresponde a procedimentos ambulatoriais de média complexidade, medicamentos e insumos excepcionai, órteses e próteses ambulatoriais e Tratamento Fora do Domicílio (TFD), sob gestão do estado”, denomina-se: ");
            a.setText("IVR");
            b.setText("FAE");
            c.setText("TFAE");
            d.setText("TFAM");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 9) {
            questaoTextView.setText("A articulação das políticas e programas, a cargo das “comissões intersetoriais”, abrangerá, em especial, a seguinte atividade: ");
            a.setText("recursos humanos");
            b.setText("recursos hídricos");
            c.setText("educação no trabalho");
            d.setText("educação ambiental");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 10) {
            questaoTextView.setText("A união, os Estados, o Distrito Federal e os Municípios exercerão, em seu âmbito administrativo, a(s) seguintes(s) atribuição(ões): ");
            a.setText("participação de formulação da política e da execução das ações de saneamento básico e colaboração na proteção e recuperação do meio ambiente;");
            b.setText("elaboração e atualização periódica do plano de saúde;");
            c.setText("participação na formulação e na execução da política de formulação e desenvolvimento de recursos humanos para a saúde;");
            d.setText("Todas as alternativas anteriores;");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 11) {
            questaoTextView.setText("Não é considerada competência da direção nacional do SUS: ");
            a.setText("estabelecer critérios, parâmetros e métodos para o controle da qualidade sanitária de produtos, substâncias e serviços de consumo a uso humano e animal.");
            b.setText("promover articulação com os órgãos educacionais e de fiscalização do exercício profissional, bem como entidades representativas de formação de recursos humanos na área da saúde.");
            c.setText("formular, avaliar, elaborar normas e participar na execução da política nacional e produção de insumos e equipamentos para a saúde, em articulação com demais órgãos governamentais.");
            d.setText("identificar os serviços estaduais e municipais de referência nacional para o estabelecimento de padrões técnicos de assistência à saúde.");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 12) {
            questaoTextView.setText("Não é competência da direção estadual do SUS: ");
            a.setText("participar, junto com os órgãos afins, do controle dos agravos do meio ambiente que tenham repercussão na saúde humana.");
            b.setText("participar da formulação da política e da execução de ações de saneamento básico.");
            c.setText("participar da ações de controle e avaliação das condições e dos ambientes de trabalho.");
            d.setText("em caráter exclusivo, formular, executar, acompanhar e avaliar a política de substâncias e equipamentos para a saúde humana e dos animais.");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 13) {
            questaoTextView.setText("A união poderá executar ações de vigilância epidemiológica e sanitária em circunstâncias especiais, como na ocorrência de agravos inusitados à saúde, que possam escapar do controle do(a) ________________ do Sistema Único de Saúde (SUS) ou que representem risco de disseminação nacional. ");
            a.setText("direção municipal");
            b.setText("direção estadual");
            c.setText("direção nacional");
            d.setText("Sistema Nacional de Sangue");
            e.setText("Sistema Nacional de Saúde");
            alt = R.id.b;
        }
        if (question == 14) {
            questaoTextView.setText("Estabelecer o Sistema Nacional de Auditoria e coordenar a avaliação técnica e financeira do SUS em todo o Território Nacional em cooperação técnica com os Estados, Municípios e Distrito Federal, compete ao(à): ");
            a.setText("direção distrital do SUS");
            b.setText("direção municipal do SUS");
            c.setText("direção nacional do SUS");
            d.setText("direção estadual do SUS");
            e.setText("direção internacional do SUS");
            alt = R.id.c;
        }
        if (question == 15) {
            questaoTextView.setText("Para o estabelecimento de valores a serem transferidos aos Estados, Distrito Federal e Município pelo SUS, será utilizada a combinação dos seguintes critérios, segundo análise técnica de programas e projetos: ");
            a.setText("perfil demográfico da região e perfil epidemiológico da população a ser coberta.");
            b.setText("características quantitativas e qualitativas da rede de saúde na área.");
            c.setText("desempenho técnico, econômico e financeiro no período anterior.");
            d.setText("todas as alternativas anteriores.");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 16) {
            questaoTextView.setText("Não se enquadra como competência da direção municipal do SUS, executar serviços de: ");
            a.setText("vigilância epidemiológica e sanitária.");
            b.setText("alimentação e nutrição.");
            c.setText("saneamento básico e habitação.");
            d.setText("saúde do trabalhador");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 17) {
            questaoTextView.setText("Não são considerados de outras fontes os recursos do orçamento do SUS provenientes de: ");
            a.setText("alienações patrimoniais e rendimentos de capital.");
            b.setText("taxas, emolumentos e preços públicos arrecadados no âmbito do SUS.");
            c.setText("rendas eventuais inclusive comerciais e industriais.");
            d.setText("multas por infração no trânsito");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 18) {
            questaoTextView.setText("A União, os Estados, o Distrito Federal e os Municípios exercerão, em seu âmbito administrativo, as seguintes atribuições, excetuando-se: ");
            a.setText("definição das instâncias e mecanismos de controle, avaliação  e de fiscalização das ações e serviços de saúde.");
            b.setText("administração dos recursos orçamentários e financeiros destinados, em cada ano, à saúde.");
            c.setText("acompanhamento, avaliação e divulgação do nível de saúde da população e das condições ambientais.");
            d.setText("definição de saúde pública a nível populacional.");
            e.setText("formular, avaliar e apoiar políticas de alimentação e nutrição.");
            alt = R.id.e;
        }
        if (question == 19) {
            questaoTextView.setText("Todos os itens abaixo referem-se à competência da direção nacional do SUS, excetuando-se: ");
            a.setText("formular, avaliar e apoiar políticas de alimentação e nutrição.");
            b.setText("promover a descentralização para as Unidades Federadas e para os Municípios, dos serviços e ações de saúde, respectivamente, de abrangência estadual e municipal.");
            c.setText("identificar os serviços estaduais e municipais de referência nacional para estabelecimento de padrões técnicos de assistência à saúde.");
            d.setText("acompanhar, controlar e avaliar as ações e os serviços de saúde, respeitando as competências estaduais e municipais.");
            e.setText("elaborar o Planejamento Estratégico Nacional no âmbito do SUS, sem qualquer espécie de cooperação, ou seja, exclusivamente.");
            alt = R.id.e;
        }
        if (question == 20) {
            questaoTextView.setText("Marque a alternativa INCORRETA: ");
            a.setText("Quando as suas disponibilidades forem insuficientes para garantir a cobertura assistencial à população de uma determinada área, o SUS poderá recorrer aos serviços ofertados pela iniciativa privada.");
            b.setText("A participação complementar dos serviços privados de que trata a alternativa “a” será formalizada mediante contrato ou convênio, observadas, a respeito, as normas de direito público.");
            c.setText("Na hipótese da alternativa “b”, as entidades filantrópicas e as sem fins lucrativos terão preferência para participar do SUS.");
            d.setText("Os critérios e valores para a remuneração de serviços e parâmetros de cobertura assistencial serão estabelecidos pela direção nacional do SUS, aprovado no Ministério da Saúde.");
            e.setText("Será permitida a destinação de subvenções e auxílios a instituições prestadoreas de serviços de saúde com finalidade lucrativa.");
            alt = R.id.d;
        }
        if (question == 21) {
            questaoTextView.setText("Todas as alternativas abaixo descrevem competências da direção nacional do SUS, excetuando-se: ");
            a.setText("Definir e coordenar os sistemas.");
            b.setText("de planos de saúde administrados por empresas privadas de capital estrangeiro.");
            c.setText("de rede de laboratórios de saúde pública.");
            d.setText("de vigilância epidemiológicas");
            e.setText("vigilância sanitária");
            alt = R.id.b;
        }
        if (question == 22) {
            questaoTextView.setText("NÂO compete à direção nacional do SUS, “Participar na formulação e na implementação das políticas”: ");
            a.setText("de controle das agressões ao meio ambiente.");
            b.setText("de saneamento básico;");
            c.setText("relativas às condições e aos ambientes de trabalho.");
            d.setText("de rede integradas de assistência de alta e média complexidade.");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 23) {
            questaoTextView.setText("Não se insere nas competências da direção estadual do SUS “coordenar e, em caráter complementar, executar ações e serviços”: ");
            a.setText("de vigilância epidemiológica");
            b.setText("de vigilância sanitária");
            c.setText("de alimentação e nutrição");
            d.setText("de saúde do empregador");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 24) {
            questaoTextView.setText("Todos os itens abaixo enumeram princípios norteadores das ações e serviços de saúde que integram o SUS, excetuando-se: ");
            a.setText("igualdade da assistência à saúde, privilegiando os idosos.");
            b.setText("direito à informação, às pessoas assistidas, sobre sua saúde.");
            c.setText("divulgação de informações quanto ao potencial dos serviços dessaúde e a sua utilização pelo usuários.");
            d.setText("utilização da epidemiologia para o estabelecimento de prioridades, a alocação de recursos e a orientação programática.");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 25) {
            questaoTextView.setText("A direção do SUS é exercida no âmbito __________, pelas respectivas Secretarias de Saúde ou órgãos equivalentes. ");
            a.setText("dos Estados");
            b.setText("do Distrito Federal");
            c.setText("dos Municípios");
            d.setText("Todas as alternativas anteriores.");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 26) {
            questaoTextView.setText("São fatores determinantes e condicionantes da saúde: ");
            a.setText("o trabalho e economia nacional");
            b.setText("a renda e o desenvolvimento industrial");
            c.setText("a educação e o desenvolvimento mundial");
            d.setText("a educação e renda");
            e.setText("o transporte e lazer");
            alt = R.id.e;
        }
        if (question == 27) {
            questaoTextView.setText("Pela lei 8.080/90 os “níveis de saúde da população” expressam: ");
            a.setText("a organização social do país.");
            b.setText("o desenvolvimento mundial.");
            c.setText("a organização econômica do país.");
            d.setText("a organização econômica do estado.");
            e.setText("as alternativas “a” e “c” estão corretas.");
            alt = R.id.e;
        }
        if (question == 28) {
            questaoTextView.setText("Ao conjunto de ações e serviços de saúde prestados por órgãos e instituições públicas federais, estaduais e municipais, da administração direta e indireta e das fundações mantidas pelo Poder Público, constitui o(a): ");
            a.setText("Ministério da Saúde");
            b.setText("Sistema Único de Saúde");
            c.setText("Ministério da Educação");
            d.setText("Ministério da Previdência Social ");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 29) {
            questaoTextView.setText("No âmbito jurídico institucional, destacam-se como Leis Orgânicas da Saúde: ");
            a.setText("Constituição Federal");
            b.setText("Leis 8.080/90 e 8.142/90.");
            c.setText("Decreto 99.438/90");
            d.setText("Normas Operacionais Básicas");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 30) {
            questaoTextView.setText("O SUS foi regulamentado pelo(a): ");
            a.setText("Constituição Federal");
            b.setText("Lei 8.142/90");
            c.setText("Lei 8.080/90");
            d.setText("Decreto 99.438/90");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 31) {
            questaoTextView.setText("O SUS foi estabelecido: ");
            a.setText("pelo Ministro da Saúde");
            b.setText("pelo Presidente da República");
            c.setText("pela Constituição Federal");
            d.setText("pelo Senado Federal");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 32) {
            questaoTextView.setText("O conjunto de ações e serviços de saúde, prestados por órgãos e instituições, ________________, constitui o SUS. ");
            a.setText("exclusivamente federais");
            b.setText("exclusivamente privadas");
            c.setText("exclusivamente municipais");
            d.setText("exclusivamente federais e privadas");
            e.setText("federais, municipais e estaduais, dentre outras.");
            alt = R.id.e;
        }
        if (question == 33) {
            questaoTextView.setText("A sigla CONFINS significa: ");
            a.setText("Conselho Nacional de Saúde");
            b.setText("Conselho Nacional de Secretários Municipais de Saúde");
            c.setText("Conselho Nacional de Secretários Estaduais de Saúde");
            d.setText("Conselho Nacional de Financiamento da Saúde");
            e.setText("Contribuição Social para o Financiamento de Seguridade Social");
            alt = R.id.e;
        }
        if (question == 34) {
            questaoTextView.setText("A sigla SMS significa: ");
            a.setText("Secretaria Municipal de Saúde");
            b.setText("Sistema Municipal de Saúde");
            c.setText("Sistema Municipal de Auditoria");
            d.setText("Sistema Municipal Sanitário");
            e.setText("Sistema Municipal de Serviços");
            alt = R.id.a;
        }
        if (question == 35) {
            questaoTextView.setText("A sigla IVISA significa: ");
            a.setText("Índice de Valorização de Informação de Vigilância Sanitária");
            b.setText("Instituto de Vigilância Sanitária");
            c.setText("Instituto de Vigilância da Valorização da Saúde");
            d.setText("Instituto Nacional de Impacto Social e Ambiental");
            e.setText("Índice de Valorização do Impacto em Vigilância Sanitária");
            alt = R.id.e;
        }
        if (question == 36) {
            questaoTextView.setText("A sigla PPI significa: ");
            a.setText("Programação Pactuada e Integrada");
            b.setText("Programa Pactuado Integrado");
            c.setText("Programa Integrado Pactuado");
            d.setText("Piso Pactuado e Integral");
            e.setText("Programa Público Institucional");
            alt = R.id.a;
        }
        if (question == 37) {
            questaoTextView.setText("O(a) _______________ regula, em todo o território nacional, as ações e serviços de saúde, executados isolada ou conjuntamente, em caráter permanente ou eventual, por pessoas naturais ou jurídicas de direito Público ou Privado. ");
            a.setText("Constituição Federal");
            b.setText("NOB");
            c.setText("Senado Federal");
            d.setText("Câmara dos Deputados");
            e.setText("Lei 8.080/90");
            alt = R.id.e;
        }
        if (question == 38) {
            questaoTextView.setText("Ao conjunto de ações e serviços de saúde, prestados por órgãos e instituições públicas federais, estaduais e municipais, da Administração direta e indireta e das fundações mantidas pelo Poder Público, denominamos de: ");
            a.setText("SUS");
            b.setText("NOB");
            c.setText("SNA");
            d.setText("SVS");
            e.setText("NOM");
            alt = R.id.a;
        }
        if (question == 39) {
            questaoTextView.setText("Fazem parte do SUS as instituições ___________ de controle de qualidade. ");
            a.setText("Federais");
            b.setText("Estaduais");
            c.setText("Municipais");
            d.setText("Todas as alternativas anteriores");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 40) {
            questaoTextView.setText("A iniciativa privada ____________ do SUS. ");
            a.setText("não poderá participar");
            b.setText("poderá participar");
            c.setText("poderá participar, mas deverá ser autorizado pelo Senado.");
            d.setText("caso seja filantrópica, poderá participar.");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 41) {
            questaoTextView.setText("De acordo com a Lei 8.080/90, a identificação e divulgação dos fatores condicionantes e determinantes da saúde, é uma(a) _________ do SUS. ");
            a.setText("dos princípios");
            b.setText("dos objetivos");
            c.setText("das diretrizes");
            d.setText("das normas");
            e.setText("dos campos de atuação");
            alt = R.id.b;
        }
        if (question == 42) {
            questaoTextView.setText("Não está incluída no campo de atuação do SUS: ");
            a.setText("a formulação e execução da política habitacional");
            b.setText("da vigilância nutricional");
            c.setText("da orientação alimentar");
            d.setText("da fiscalização nutricional");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 43) {
            questaoTextView.setText("De acordo com a Lei 8.080/90, a “um conjunto de ações que proporcionam o conhecimento, a detecção ou prevenção de qualquer mudança nos fatores determinantes e condicionantes de saúde individual ou coletiva, com a finalidade de recomendar e adotar as medidas de prevenção e controle das doenças ou agravos”, denominamos: ");
            a.setText("vigilância sanitária");
            b.setText("vigilância epidemiológica");
            c.setText("saúde do trabalhador");
            d.setText("avaliação do impacto ambiental");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 44) {
            questaoTextView.setText("Pela Lei 8.080/90, entende-se por ______________, um conjunto de atividades que se destina, através das ações de vigilância epidemiológica e sanitária, à promoção e proteção da saúde dos trabalhadores, assim como visa à recuperação e reabilitação da saúde dos trabalhadores submetidos aos riscos e agravos advindos das condições de trabalho. ");
            a.setText("vigilância sanitária");
            b.setText("vigilância epidemiológica");
            c.setText("vigilância endemiológica");
            d.setText("saúde do trabalhador");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 45) {
            questaoTextView.setText("A universalidade de acesso à saúde, é um dos princípio do(a): ");
            a.setText("Ministério da Previdência Social");
            b.setText("SUS");
            c.setText("Ministério da Integração Social");
            d.setText("NOB");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 46) {
            questaoTextView.setText("Aos municípios ________________ constituir consórcios para desenvolver em conjunto as ações e os serviços de saúde que lhes correspondam. ");
            a.setText("é proibido.");
            b.setText("é proibido, em alguns casos.");
            c.setText("é defeso.");
            d.setText("é permitido");
            e.setText("é vedado");
            alt = R.id.c;
        }
        if (question == 47) {
            questaoTextView.setText("De acordo com o texto da Lei 8.080/90, aplica-se aos consórcios administrativos intermunicipais o princípio do(a): ");
            a.setText("direção única");
            b.setText("direção descentralizada");
            c.setText("integralidade de assistência");
            d.setText("direção hierarquizada");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 48) {
            questaoTextView.setText("No nível municipa, o SUS, organiza-se em: ");
            a.setText("bairros");
            b.setText("conjuntos");
            c.setText("distritos");
            d.setText("regiões administrativas");
            e.setText("circunscrições");
            alt = R.id.c;
        }
        if (question == 49) {
            questaoTextView.setText("A direção do SUS, no âmbito da União, será exercido pelo(a): ");
            a.setText("Governador");
            b.setText("Ministério da Saúde");
            c.setText("Conselho Nacional de Saúde");
            d.setText("Secretaria de Saúde ou órgão equivalente");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 50) {
            questaoTextView.setText("A direção do SUS, no âmbito dos Estados, será exercido pelo(a): ");
            a.setText("Governador");
            b.setText("Secretaria de Saúde ou órgão equivalente");
            c.setText("Ministro da saúde");
            d.setText("Conselho Estadual de Saúde");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 51) {
            questaoTextView.setText("As comissões intersetoriais de âmbito nacional, são subordinadas ao(à): ");
            a.setText("Presidente da República");
            b.setText("SUS");
            c.setText("Conselho Nacional de Saúde");
            d.setText("Ministério da Saúde");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 52) {
            questaoTextView.setText("É finalidade dos(as)_____________, articular políticas e programas de interesse para a saúde, cuja execução envolva áreas não compreendidas no âmbito do SUS. ");
            a.setText("Conselhos de Saúde");
            b.setText("Comissões intersetoriais");
            c.setText("Comissões Permanentes de Integração");
            d.setText("Consórcios administrativos");
            e.setText("Comissões do Ministério da Saúde");
            alt = R.id.c;
        }
        if (question == 53) {
            questaoTextView.setText("Formular, avaliar e apoiar políticas de alimentação e nutrição, é competência: ");
            a.setText("da direção nacional do SUS");
            b.setText("da direção municipal do SUS");
            c.setText("da direção estadual do SUS");
            d.setText("da União");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 54) {
            questaoTextView.setText("De acordo com a Lei 8.080/90 compete ao(à) ______________ as atribuições reservadas aos Estados e aos Municípios.");
            a.setText("Distrito Federal");
            b.setText("União");
            c.setText("Presidente da República");
            d.setText("Ministro da Saúde");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 55) {
            questaoTextView.setText("Na prestação de serviços de assistência à saúde, serão observados os princípios éticos e as normas expedidas pelo __________________ quanto às condições para seu funcionamento. ");
            a.setText("Conselho Nacional de Saúde");
            b.setText("Órgão de direção do SUS");
            c.setText("Ministério da Saúde");
            d.setText("Ministro da Saúde");
            e.setText("Congresso Nacional");
            alt = R.id.a;
        }
        if (question == 56) {
            questaoTextView.setText("A Lei 8.080/90 dispõe textualmente que “é vedada a participação direta ou indireta de empresas ou de capitais estrangeiros na assistência à saúde, salvo através de doações de organismos internacionais vinculados aos(à)_________________, de entidades de cooperação técnica e de financiamentos e empréstimos”. ");
            a.setText("Empresas Internacionais que atuam na área de Seguro Saúde");
            b.setText("Empresas Internacionais que atuam na área de Seguro Saúde");
            c.setText("Bancos Internacionais");
            d.setText("Bancos Nacionais");
            e.setText("Organização das Nações Unidas (ONU)");
            alt = R.id.e;
        }
        if (question == 57) {
            questaoTextView.setText("Quando as suas disponibilidades forem insuficientes para garantir a cobertura assistencial à população de uma determinada área o Sistema Único de Saúde (SUS) ________________ recorrer aos serviços ofertados pela iniciativa privada. ");
            a.setText("com autorização do Congresso Nacional, deverá");
            b.setText("está proibido de");
            c.setText("deverá obrigatoriamente");
            d.setText("poderá");
            e.setText("não poderá");
            alt = R.id.d;
        }
        if (question == 58) {
            questaoTextView.setText("Em relação as Normas Operacionais Básicas (NOB) e Norma Operacional de Assistência à Saúde (NOAS), assinale a alternativa correta.");
            a.setText("As NOB têm como objetivo principal regulamentar o Sistema Único de Saúde.");
            b.setText("A NOB 96 é um marco na questão da centralização das ações e serviços de saúde, no qual o nível estadual consegue maior autonomia para prestação de serviços básicos de saúde.");
            c.setText("A operacionalização da NOB-96 se dá preferencialmente no nível federal, pois a análise da situação de saúde só pode ser realizada de forma equitativa mediante a tomada de decisão do governo federal.");
            d.setText("A operacionalização da NOB-96 se dá preferencialmente no nível federal, pois a análise da situação de saúde só pode ser realizada de forma equitativa mediante a tomada de decisão do governo federal.");
            e.setText("A NOAS-SUS atualiza a regulamentação da assistência, considerando os avanços já obtidos e enfocando os desafios a serem superados no processo permanente de consolidação e aprimoramento do Sistema Único de Saúde, e cria em 2001 o Piso da Atenção Básica (PAB).");
            alt = R.id.d;
        }
        if (question == 59) {
            questaoTextView.setText("De acordo com a Lei orgânica de saúde 8080/90, assinale a alternativa correta.");
            a.setText("Esta lei dispõe sobre a participação da comunidade na gestão do Sistema Único de Saúde (SUS) e sobre as transferências intergovernamentais de recursos financeiros na área da saúde.");
            b.setText("A lei 8080/90 cria o Piso da Atenção Básica (PAB), que consiste em recursos financeiros destinados a investimentos de procedimentos e ações de assistência básica, tipicamente municipal. Onde é distribuído per capta um valor de 10 a 18 reais por habitante do município.");
            c.setText("De acordo com a Lei 8080/90 a iniciativa privada poderá participar do Sistema Único de Saúde (SUS), em caráter complementar.");
            d.setText("A lei 8080/90 altera os artigos. 34, 35, 156, 160, 167 e 198 da Constituição Federal e acrescenta artigo ao ato das Disposições Constitucionais Transitórias, para assegurar os recursos mínimos para o financiamento das ações e serviços públicos de saúde.");
            e.setText("A Emenda constitucional número 29 foi proposta pela constituição federal de 1988, regulamentada pela lei 8080/90, porém só entrou efetivamente em vigor no ano de 2006.");
            alt = R.id.c;
        }
        if (question == 60) {
            questaoTextView.setText("A Lei que dispõe sobre a participação da comunidade na gestão do Sistema Único de Saúde (SUS) é");
            a.setText("a Lei n.º 8.142, de 28 de dezembro de 1990");
            b.setText("a Lei n.º 10.406, de 10 de janeiro de 2002");
            c.setText("a Lei n.º 5.869, de 11 de janeiro de 1973");
            d.setText("a Lei n.º 8.080, de 19 de dezembro de 1990");
            e.setText("o Decreto-Lei nº 2.848, de 7 de dezembro de 1940");
            alt = R.id.a;
        }
        if (question == 61) {
            questaoTextView.setText("Acerca da Ordem Social, de acordo com a Constituição Federal brasileira, de 05 de outubro de 1988, é correto afirmar que");
            a.setText("a seguridade social compreende um conjunto integrado de ações de iniciativa exclusiva dos Poderes Públicos.");
            b.setText("a seguridade social será financiada por toda a sociedade, de forma direta e indireta, nos termos da lei, mediante recursos provenientes dos orçamentos da União, dos Estados, do Distrito Federal e dos Municípios e de contribuições sociais.");
            c.setText("a saúde é direito de todos e dever de cada cidadão.");
            d.setText("não são de relevância pública as ações e serviços de saúde.");
            e.setText("a assistência à saúde é exclusiva do Poder Público.");
            alt = R.id.b;
        }
        if (question == 62) {
            questaoTextView.setText("A Constituição Federal brasileira, de 05 de outubro de 1988, declara que a saúde é direito de todos e dever");
            a.setText("do particular");
            b.setText("da escola");
            c.setText("dos planos de saúde");
            d.setText("do Estado");
            e.setText("das empresas");
            alt = R.id.d;
        }
        if (question == 63) {
            questaoTextView.setText("Conforme dispõe o art. 28 da Lei nº 8.080, de 19 de setembro de 1990, os cargos e funções de chefia, direção e assessoramento, no âmbito do Sistema Único de Saúde (SUS), só poderão ser exercidos");
            a.setText("em regime de tempo integral.");
            b.setText("em regime de tempo parcial de 04 (quatro) horas.");
            c.setText("em escala de 24 (vinte e quatro) horas por 48 (quarenta e oito) horas.");
            d.setText("sem ter horário determinado, por tratar-se de cargo de confiança.");
            e.setText("em regime de tempo parcial de 06 (seis) horas.");
            alt = R.id.a;
        }
        if (question == 64) {
            questaoTextView.setText("De acordo com o Decreto Federal nº 7.508, de 28 de junho de 2011, o acesso universal e igualitário à assistência farmacêutica pressupõe");
            a.setText("não estar o usuário assistido por ações e serviços de saúde do SUS.");
            b.setText("ter o medicamento sido prescrito por qualquer pessoa.");
            c.setText("estar a prescrição em conformidade com a RENAME e os Protocolos Clínicos e Diretrizes Terapêuticas ou com a relação específica complementar estadual, distrital ou municipal de medicamentos.");
            d.setText("não ter a dispensação ocorrido em unidades indicadas pela direção do SUS.");
            e.setText("estar o usuário assistido por ações e serviços de saúde particular.");
            alt = R.id.c;
        }
        if (question == 65) {
            questaoTextView.setText("Assinale a alternativa correta.");
            a.setText("O dever do Estado de garantir a saúde consiste na formulação e execução de políticas econômicas e sociais que visem à redução de riscos de doenças e de outros agravos e no estabelecimento de condições que assegurem acesso universal e igualitário às ações e aos serviços para a sua promoção, proteção e recuperação.");
            b.setText("O dever do Estado em garantir a saúde exclui o das pessoas, da família, das empresas e da sociedade.");
            c.setText("O Sistema Único de Saúde é o conjunto de ações e serviços de saúde, prestados por órgãos e instituições públicas federal, estadual e municipal, exclusivamente da Administração Direta.");
            d.setText("A iniciativa privada participa concorrentemente do Sistema Único de Saúde.");
            e.setText("A saúde garantida pelo Sistema Único é exclusivamente física.");
            alt = R.id.a;
        }
        if (question == 66) {
            questaoTextView.setText("Assinale a alternativa correta.");
            a.setText("Universalidade de acesso aos serviços de saúde, nos primeiros níveis de assistência, é um dos princípios do Sistema Único de Saúde.");
            b.setText("Adireção do Sistema Único de Saúde (SUS) é dividida e descentralizada, sendo exercida a direção em cada esfera de governo.");
            c.setText("Os municípios não poderão constituir consórcios para desenvolver em conjunto as ações e os serviços de saúde que lhe correspondam.");
            d.setText("No nível municipal, o Sistema Único de Saúde não poderá organizar-se em distritos, de forma a integrar e articular recursos, técnicas e práticas voltadas para a cobertura total das ações de saúde.");
            e.setText("É princípio do Sistema Único de Saúde a organização dos serviços públicos de modo a evitar a duplicidade de meios para fins idênticos.");
            alt = R.id.e;
        }
        if (question == 67) {
            questaoTextView.setText("Assinale a alternativa correta.");
            a.setText("A Conferência de Saúde se reunirá a cada ano para avaliar a situação de saúde e propor diretrizes para formulação da política de saúde nos níveis correspondentes.");
            b.setText("O Sistema Único de Saúde contará, em cada esfera de governo, com a Conferência de Saúde e com o Conselho de Saúde, como instâncias colegiadas.");
            c.setText("Os recursos do Fundo Nacional de Saúde não serão alocados como despesas de custeio e de capital do Ministério da Saúde, seus órgãos e entidades, da administração direta e indireta");
            d.setText("Para receberem os recursos do Governo Federal, os municípios e os Estados não precisam ter plano de saúde.");
            e.setText("O Conselho Nacional de Secretários de Saúde e o Conselho Nacional de Secretarias Municipais de Saúde não terão representação no Conselho Nacional de Saúde.");
            alt = R.id.b;
        }
        if (question == 68) {
            questaoTextView.setText("Assinale a alternativa correta.");
            a.setText("Não é princípio do Sistema Único de Saúde a conjugação dos recursos financeiros, tecnológicos, materiais e humanos da União, dos Estados e do Distrito Federal na prestação de serviços de assistência à saúde da população.");
            b.setText("Não compete ao Sistema Único de Saúde controlar e fiscalizar procedimentos e substâncias de interesse para a saúde.");
            c.setText("Asaúde é direito de todos e dever do Estado, garantido mediante políticas sociais e econômicas que visem à redução do risco de doença e de outros agravos e ao acesso universal e igualitário às ações e serviços para sua promoção, proteção e recuperação.");
            d.setText("Somente a União e os Estados têm obrigação legal de aplicar valor mínimo de recursos na saúde.");
            e.setText("Os gestores locais do Sistema Único de Saúde poderão admitir agentes comunitários de saúde e agentes de combate às endemias por meio de contratação direta, sem teste seletivo ou concurso público, de acordo com a natureza e complexidade de suas atribuições e requisitos específicos para sua atuação.");
            alt = R.id.c;
        }
        if (question == 69) {
            questaoTextView.setText("Assinale a alternativa correta.");
            a.setText("No Brasil colônia, existia um sistema de saúde estruturado e a população procurava os médicos, recorrendo aos curandeiros somente por crendice.");
            b.setText("Mesmo com a chegada da Família Real Portuguesa ao Brasil, em 1808, o sistema de saúde pública no Brasil não mudou.");
            c.setText("Até 1900, não havia no Brasil faculdade de medicina.");
            d.setText("Em 1850, é criada a Junta Central de Higiene Pública, com o objetivo de coordenar as Juntas Municipais e, especialmente, atuar no combate à febre amarela. Esta junta também passou a coordenar as atividades de polícia sanitária, vacinação contra varíola, fiscalização do exercício da medicina e a Inspetoria de Saúde dos Portos.");
            e.setText("Mesmo com a evolução da saúde pública, no final do século XVIII, a atividade dos curandeiros era respeitada e permitida.");
            alt = R.id.d;
        }
        if (question == 70) {
            questaoTextView.setText("A Constituição Federal de 1988 estabeleceu de forma relevante uma seção sobre a saúde. Qual das alternativas a seguir faz parte dessa seção?");
            a.setText("A ordem social tem como base o primado do trabalho, e como objetivo o bem-estar e a justiça sociais.");
            b.setText("A União, os Estados, o Distrito Federal e os Municípios organizarão em regime de colaboração seus sistemas de saúde.");
            c.setText("Asaúde, direito de todos e dever do Estado e da família, será promovida e incentivada com a colaboração da sociedade, visando ao pleno desenvolvimento da pessoa, seu preparo para o exercício da cidadania e sua qualificação para o trabalho.");
            d.setText("São de relevância pública as ações e serviços de saúde, cabendo ao Poder Público dispor, nos termos da lei, sobre sua regulamentação, fiscalização e controle, devendo sua execução ser feita diretamente ou através de terceiros e, também, por pessoa física ou jurídica de direito privado.");
            e.setText("Os programas suplementares de alimentação e assistência a saúde serão financiados com recursos provenientes de contribuições sociais e outros recursos orçamentários.");
            alt = R.id.d;
        }
        if (question == 71) {
            questaoTextView.setText("Compete ao Poder Público, nos termos da lei, organizar a seguridade social. Qual item NÃO se enquadra nessa competência?");
            a.setText("Uniformidade e equivalência dos benefícios e serviços às populações urbanas e rurais.");
            b.setText("Equidade na forma de participação no custeio.");
            c.setText("Habilitação e reabilitação das pessoas portadoras de deficiência e a promoção de sua integração à vida comunitária.");
            d.setText("Caráter democrático e descentralizado da administração, mediante gestão quadripartite, com participação dos trabalhadores, dos empregadores, dos aposentados e do Governo nos órgãos colegiados.");
            e.setText("Universalidade da cobertura e do atendimento.");
            alt = R.id.c;
        }
        if (question == 72) {
            questaoTextView.setText("Compete ao SUS prestar assistência às pessoas, por intermédio de ações de promoção, proteção e recuperação da saúde, com a realização integrada das ações assistenciais e das atividades preventivas. Qual das alternativas a seguir NÃO se enquadra nessas ações?");
            a.setText("Realizar ações de vigilância sanitária e epidemiológica, bem como as de saúde do trabalhador.");
            b.setText("Realizar proteção à maternidade, especialmente à gestante.");
            c.setText("Ordenar a formação de recursos humanos na área de saúde.");
            d.setText("Participar da formulação da política e da execução das ações de saneamento básico.");
            e.setText("Fiscalizar e inspecionar alimentos, compreendido o controle de seu teor nutricional, bem como bebidas e águas para consumo humano.");
            alt = R.id.b;
        }
        if (question == 73) {
            questaoTextView.setText("O que é a Comissão Intergestores Tripartites do SUS?");
            a.setText("Instância de articulação e pactuação na esfera federal que atua na direção nacional do SUS, integrada por gestores do SUS das três esferas de governo.");
            b.setText("Comissão de gestores municipais, estaduais e federais que se encarregam dos planos estaduais, regionais e de regionalização das ações e serviços propostos pelos Colegiados de Gestão Regional.");
            c.setText("Um conjunto integrado de ações de iniciativa dos poderes públicos e da sociedade destinada a assegurar os direitos relativos à saúde, à previdência e à assistência social.");
            d.setText("Gestão compartilhada nos âmbitos federal e estadual, com direção única em cada esfera de governo.");
            e.setText("Espaços estaduais de articulação e pactuação  política que objetivam orientar, regulamentar e avaliar os aspectos operacionais do processo de descentralização das ações de saúde.");
            alt = R.id.a;
        }
        if (question == 74) {
            questaoTextView.setText("A Assistência Farmacêutica faz parte das políticas e dos programas de saúde do SUS. Assinale a alternativa que trata dos princípios dessa assistência.");
            a.setText("Política pública norteadora para a formulação de políticas setoriais, entre as quais destacam-se as políticas de medicamentos, não garantindo a intersetorialidade inerente ao sistema de saúde do país (SUS) e cuja implantação envolve o setor público de atenção à saúde.");
            b.setText("Controle do avanço científico e tecnológico em relação à produção de medicamentos.");
            c.setText("Manutenção de serviços de assistência farmacêutica na rede privada de saúde, nos diferentes níveis de atenção, considerando a necessária articulação e a observância das prioridades regionais definidas nas instâncias gestoras do SUS.");
            d.setText("Parte integrante da Política Nacional de Saúde, envolvendo um conjunto de ações voltadas à promoção, proteção e recuperação da saúde e garantindo os princípios da universalidade, integralidade e equidade.");
            e.setText("Política de capacitação e formação de profissionais na área farmacêutica, visando auxiliar a divulgação do uso correto dos medicamentos em atenção à saúde da família.");
            alt = R.id.b;
        }
        if (question == 75) {
            questaoTextView.setText("De acordo com o Decreto nº 7.508 de 28/06/2011, considera-se Região de Saúde");
            a.setText("o espaço geográfico contínuo constituído por agrupamentos de Municípios limítrofes, delimitado a partir de identidades culturais, econômicas e sociais e de redes de comunicação e infraestrutura de transportes compartilhados, com a finalidade de integrar a organização, o planejamento e a execução de ações e serviços de saúde.");
            b.setText("o espaço geográfico contínuo constituído por agrupamentos de Municípios limítrofes, delimitado a partir de identidades culturais, econômicas e sociais e de redes de comunicação e infraestrutura de transportes compartilhados, com a finalidade de interagir entre os Estados, Municípios e a União.");
            c.setText("todo o território Nacional, sem delimitação de identidades culturais, econômicas e sociais e de redes de comunicação e infraestrutura de transportes compartilhados.");
            d.setText("o espaço geográfico contínuo constituído por agrupamentos de Municípios limítrofes, delimitado a partir de identidades culturais, econômicas e sociais e de redes de comunicação e infraestrutura de transportes compartilhados, com a finalidade de integrar a organização, o planejamento e a execução de ações e serviços administrativos.");
            e.setText("o espaço geográfico contínuo constituído por agrupamentos de Municípios limítrofes, sem delimitação de identidades culturais, econômicas e sociais e de redes de comunicação e infraestrutura de transportes compartilhados, com a finalidade de integrar a organização, o planejamento e a execução de ações e serviços financeiros.");
            alt = R.id.a;
        }
        if (question == 76) {
            questaoTextView.setText("A direção do Sistema Único de Saúde (SUS) é única, sendo exercida em cada esfera de governo pelos seguintes órgãos:");
            a.setText("no âmbito da União, pelo Ministério da Previdência, no âmbito dos Estados e do Distrito Federal, pela respectiva Secretaria de Saúde ou órgão equivalente e, no âmbito dos Municípios, pela respectiva Secretaria de Saúde ou órgão equivalente.");
            b.setText("o âmbito da União, pelo Ministério da Saúde, no âmbito dos Estados e do Distrito Federal, pela respectiva Secretaria de Desenvolvimento e Cidadania ou órgão equivalente; e, no âmbito dos Municípios, pela respectiva Secretaria de Saúde ou órgão equivalente.");
            c.setText("no âmbito da União, pelo Fundo Nacional de Saúde, no âmbito dos Estados e do Distrito Federal, pela respectiva Secretaria de Saúde ou órgão equivalente e no âmbito dos Municípios, pela respectiva Secretaria de Saúde ou órgão equivalente.");
            d.setText("no âmbito da União, pelo Ministério da Saúde, no âmbito dos Estados e do Distrito Federal, pela respectiva Secretaria de Saúde ou órgão equivalente e, no âmbito dos Municípios, pela respectiva Secretaria de Saúde ou órgão equivalente.");
            e.setText("no âmbito da União, pelo Ministério da Saúde, no âmbito dos Estados e do Distrito Federal, pela respectiva Secretaria de Saúde ou órgão equivalente e, no âmbito dos Municípios, pela respectiva Secretaria de Desenvolvimento e Cidadania ou órgão equivalente.");
            alt = R.id.d;
        }
        if (question == 77) {
            questaoTextView.setText("Quem poderia se beneficiar da assistência à saúde desenvolvida pelo INAMPS, antes da criação do SUS?");
            a.setText("Apenas os trabalhadores informais, sem “carteira assinada”, e seus dependentes, ou seja, não tinha o caráter universal.");
            b.setText("Todos os trabalhadores tanto da economia formal como os informais e seus dependentes, ou seja, tinha o caráter universal.");
            c.setText("Apenas os funcionários públicos da União e seus dependentes, ou seja, não tinha o caráter universal.");
            d.setText("Apenas os trabalhadores da economia formal, com “carteira assinada”, e seus dependentes, ou seja, não tinha o caráter universal.");
            e.setText("A toda população indiscriminadamente, demonstrando assim o caráter universal da assistência.");
            alt = R.id.d;
        }
        if (question == 78) {
            questaoTextView.setText("Para ser instituída, a Região de Saúde deve conter, no mínimo, ações e serviços de");
            a.setText("atenção primária, atenção psicossocial, atenção ambulatorial especializada e hospitalar e vigilância sanitária.");
            b.setText("urgência e emergência, atenção psicossocial, vigilância sanitária e atenção ambulatorial especializada e hospitalar.");
            c.setText("atenção primária, urgência e emergência, atenção epidemiológica, atenção ambulatorial especializada e hospitalar e vigilância em saúde. ");
            d.setText("vigilância sanitária, atenção primária, urgência e emergência, atenção psicossocial, atenção ambulatorial especializada e hospitalar.");
            e.setText("atenção primária, urgência e emergência, atenção psicossocial, atenção ambulatorial especializada e hospitalar e vigilância em saúde.");
            alt = R.id.e;
        }
        if (question == 79) {
            questaoTextView.setText("O acesso universal e igualitário à assistência farmacêutica pressupõe, cumulativamente:");
            a.setText("estar o usuário assistido por ações e serviços de saúde do SUS, ter o medicamento sido prescrito por profissional de saúde, no exercício regular de suas funções no SUS, estar a prescrição em conformidade com a RENAME e os Protocolos Clínicos e Diretrizes Terapêuticas ou com a relação específica complementar estadual, distrital ou municipal de medicamentos e ter a dispensação ocorrido em unidades indicadas pela direção do SUS.");
            b.setText("estar a prescrição em conformidade com a RENAME e os Protocolos Clínicos e Diretrizes Terapêuticas ou com a relação específica complementar estadual, distrital ou municipal de medicamentos, porém devido ao acesso universal e igualitário os medicamentos poderão ser prescritos por todos e quaisquer médicos no exercício regular da profissão e atingindo a toda a população.");
            c.setText("o usuário, devido ao acesso universal e igualitário, não necessita estar assistido por ações e serviços de saúde do SUS, porém o medicamento deverá ter sido prescrito por profissional de saúde, no exercício regular de suas funções no SUS, estar a prescrição em conformidade com a RENAME e os Protocolos Clínicos e Diretrizes Terapêuticas ou com relação específica complementar estadual, distrital bou municipal de medicamentos e ter a dispensação ocorrido em unidades indicadas pela direção do SUS.");
            d.setText("estar a prescrição em conformidade com a RENAME e os Protocolos Clínicos e Diretrizes Terapêuticas ou com a relação específica complementar apenas no âmbito distrital, de medicamentos e ter a  dispensação ocorrido em unidades indicadas pela direção do SUS, devendo estar, o usuário, assistido por ações e serviços de saúde do SUS.");
            e.setText("estar o usuário assistido por ações e serviços de saúde do SUS, porém, devido ao acesso universal e igualitário à assistência farmacêutica, a prescrição da medicação não necessita dos Protocolos Clínicos e seguir as Diretrizes Terapêuticas.");
            alt = R.id.a;
        }
        if (question == 80) {
            questaoTextView.setText("De acordo com as diretrizes da Resolução 453/2012 do Conselho Nacional da Saúde, o Plenário dos Conselhos de Saúde");
            a.setText("se reunirá, no mínimo, a cada mês e, extraordinariamente, quando necessário, e terá como base o seu Regimento Interno. A pauta e o material de apoio às reuniões devem ser encaminhados aos conselheiros com antecedência mínima de 10 (dez) dias.");
            b.setText("se reunirá, no mínimo, a cada quatro meses e, extraordinariamente, quando necessário, e terá como base o seu Regimento Interno. A pauta e o material de apoio às reuniões devem ser encaminhados aos conselheiros com antecedência mínima de 15 (quinze) dias.");
            c.setText("se reunirá, no mínimo, uma vez por semana e, extraordinariamente, quando necessário, e terá como base o seu Regimento Interno. A pauta e o material de apoio às reuniões devem ser encaminhados aos conselheiros com antecedência mínima de 24 (vinte e quatro) horas.");
            d.setText("se reunirá em todos os finais de semana e terá como base o seu Regimento Interno. A pauta e o material de apoio às reuniões devem ser encaminhados aos conselheiros com antecedência mínima de 24 (vinte e quatro) horas.");
            e.setText("se reunirá, no mínimo, a cada ano e, extraordinariamente, quando necessário, e terá como base o seu Regimento Interno. A pauta e o material de apoio às reuniões devem ser encaminhados aos conselheiros com antecedência mínima de 5 (cinco) dias.");
            alt = R.id.a;
        }
        if (question == 81) {
            questaoTextView.setText("De acordo com o que expressa a Constituição Federal, no que tange a participação da iniciativa privada na assistência à saúde, assinale a alternativa correta.");
            a.setText("As instituições privadas não poderão participar do Sistema Único de Saúde. Somente será possível, segundo diretrizes deste e mediante convênio, participação de entidades filantrópicas e as sem fins lucrativos.");
            b.setText("As instituições privadas poderão participar de forma complementar do sistema único de saúde, segundo diretrizes deste, mediante contrato de direito público ou convênio, vedada a participação de entidades filantrópicas e as sem fins lucrativos.");
            c.setText("As instituições privadas poderão participar do Sistema Único de Saúde somente de forma subsidiária, quando não houver serviço público disponível, mediante contrato de direito público, tendo preferência as entidades filantrópicas e as sem fins lucrativos.");
            d.setText("As instituições privadas poderão participar do Sistema Único de Saúde somente de forma subsidiária, quando não houver serviço público disponível, mediante convênio com as entidades filantrópicas e as sem fins lucrativos.");
            e.setText("As instituições privadas poderão participar de forma complementar do Sistema Único de Saúde, segundo diretrizes deste, mediante contrato de direito público ou convênio, tendo preferência as entidades filantrópicas e as sem fins lucrativos.");
            alt = R.id.e;
        }
        if (question == 82) {
            questaoTextView.setText("De acordo com as disposições da Lei Orgânica da Saúde (Lei 8.080/90), a incorporação, a exclusão ou a alteração pelo SUS de novos medicamentos, produtos e procedimentos, bem como a constituição ou a alteração de protocolo clínico ou de diretriz terapêutica são atribuições");
            a.setText("do Conselho da Saúde, assessorado pelo Ministério de Ciências e Tecnologia.");
            b.setText("do Ministério da Ciência e Tecnologia, assessorado pela Conferência Nacional de Saúde.");
            c.setText("do Ministério da Saúde, assessorado pelo Conselho Nacional de Saúde.");
            d.setText("do Ministério da Saúde, assessorado pela Comissão Nacional de Incorporação de Tecnologias no SUS.");
            e.setText("exclusivas do Município, assessorado pela Conferência Nacional de Saúde.");
            alt = R.id.d;
        }
        if (question == 83) {
            questaoTextView.setText("De acordo com o que expressa a Lei 8.142/90, os recursos do Fundo Nacional de Saúde (FNS) alocados como cobertura das ações e serviços de saúde a serem implementados pelos Municípios, Estados e Distrito Federal serão ");
            a.setText("destinados, pelo menos sessenta por cento, aos Municípios, afetando-se o restante aos Estados.");
            b.setText("destinados, pelo menos sessenta por cento, aos Estados, afetando-se o restante aos Municípios.");
            c.setText("destinados, pelo menos setenta por cento, aos Municípios, afetando-se o restante aos Estados.");
            d.setText("destinados, pelo menos setenta por cento, aos Estados, afetando-se o restante aos Municípios.");
            e.setText("divididos igualitariamente.");
            alt = R.id.c;
        }
        if (question == 84) {
            questaoTextView.setText("De acordo com as definições do Decreto Presidencial nº 7.508/2011, assinale a alternativa correta.");
            a.setText("Portas de Entrada são instâncias de pactuação consensual entre os entes federativos para definição das regras da gestão compartilhada do SUS.");
            b.setText("A Relação Nacional de Ações e Serviços de Saúde (RENASES) compreende todas as ações e serviços que o SUS oferece ao usuário para atendimento da integralidade da assistência à saúde.");
            c.setText("A Conferência Nacional de Saúde, em conjunto com o Poder Legislativo, estabelece as diretrizes a serem observadas na elaboração dos planos de saúde, de acordo com as características epidemiológicas e da organização de serviços nos entes federativos e nas Regiões de Saúde.");
            d.setText("O processo de planejamento da saúde será descendente e independente, desde o nível federal até o local, devendo, no entanto, ser ouvidas as respectivas Conferências de Saúde, compatibilizando-se as necessidades das políticas de saúde com a disponibilidade de recursos financeiros.");
            e.setText("O Conselho de Saúde é o órgão competente para dispor sobre a Relação Nacional de Medicamentos Essenciais (RENAME) e os Protocolos Clínicos e Diretrizes Terapêuticas em âmbito nacional.");
            alt = R.id.b;
        }
        if (question == 85) {
            questaoTextView.setText("Assinale a alternativa correta.");
            a.setText("Constitui, o Sistema Único de Saúde, o conjunto de ações e serviços de saúde, prestados por órgãos e instituições públicas federais, estaduais e municipais, da Administração direta e indireta e das fundações mantidas pelo Poder Público.");
            b.setText("A iniciativa privada poderá participar do Sistema Único de Saúde, em caráter concorrente com a iniciativa pública.");
            c.setText("Não estão incluídas no Sistema Único de Saúde as instituições públicas de controle de qualidade, pesquisa e produção de insumos, medicamentos, inclusive de sangue e hemoderivados, e de equipamentos para saúde.");
            d.setText("Não são objetivos do Sistema Único de Saúde (SUS) as atividades preventivas.");
            e.setText("O desenvolvimento de políticas econômicas não tem relação com os objetivos do SUS.");
            alt = R.id.a;
        }
        if (question == 86) {
            questaoTextView.setText("Assinale a alternativa que NÃO apresenta um princípio ou diretrizes do Sistema Único de Saúde.");
            a.setText("Direito à informação, às pessoas assistidas, sobre sua saúde, exceto em casos de doença terminal.");
            b.setText("Divulgação de informações quanto ao potencial dos serviços de saúde e a sua utilização pelo usuário.");
            c.setText("Descentralização político-administrativa, com direção única em cada esfera de governo.");
            d.setText("Integração em nível executivo das ações de saúde, meio ambiente e saneamento básico.");
            e.setText("Preservação da autonomia das pessoas na defesa de sua integridade física e moral.");
            alt = R.id.a;
        }
        if (question == 87) {
            questaoTextView.setText("Assinale a alternativa correta.");
            a.setText("Em sua constituição, o Sistema Único de Saúde não tem a participação da iniciativa privada.");
            b.setText("As Regiões de Saúde serão instituídas pelo Estado, em articulação com os Municípios, inexistindo Regiões de Saúde interestadual.");
            c.setText("A instituição das Regiões de Saúde observará cronograma no Plano Plurianual do Governo Federal");
            d.setText("As Regiões de Saúde não serão referência para as transferências de recursos entre os entes federativos.");
            e.setText("Para ser instituída, a Região de Saúde deve conter, no mínimo, ações e serviços de atenção primária, urgência e emergência, atenção psicossocial, atenção ambulatorial especializada e hospitalar e vigilância em saúde.");
            alt = R.id.e;
        }
        if (question == 88) {
            questaoTextView.setText("Quanto à seguridade social, assinale a alternativa correta.");
            a.setText("A saúde é direito de todos e dever do Estado, garantido mediante políticas sociais e econômicas, com acesso preferencial aos mais pobres.");
            b.setText("As ações e serviços públicos de saúde integram uma rede centralizada e constitui um sistema único.");
            c.setText("A União aplicará anualmente, em ações e serviços públicos de saúde, valor não inferior a 15% (quinze por cento) da receita corrente líquida do respectivo exercício financeiro.");
            d.setText("As ações e serviços públicos de saúde não contarão com a participação da comunidade");
            e.setText("A assistência à saúde é exclusiva do Poder Público.");
            alt = R.id.c;
        }
        if (question == 89) {
            questaoTextView.setText("Quanto à seguridade social, assinale a alternativa correta.");
            a.setText("As instituições privadas poderão participar de forma subsidiária do Sistema Único de Saúde.");
            b.setText("É permitida a destinação de recursos públicos para auxiliar as instituições privadas com fins lucrativos.");
            c.setText("É vedada a participação direta ou indireta de empresas ou capitais estrangeiros na assistência à saúde do País, salvo nos casos previstos em lei.");
            d.setText("Não compete ao Sistema Único de Saúde ordenar a formação de recursos humanos na área de saúde.");
            e.setText("Ao Sistema Único de Saúde, compete colaborar na proteção do meio ambiente, exceto o meio ambiente do trabalho.");
            alt = R.id.c;
        }
        if (question == 90) {
            questaoTextView.setText("Quando uma Secretaria de Saúde investe mais recursos onde há maior carência na tentativa de diminuir as desigualdades, ela está agindo em consonância com o princípio da:");
            a.setText("universalidade");
            b.setText("equidade");
            c.setText("descentralização");
            d.setText("intersetorialidade");
            e.setText("integralidade");
            alt = R.id.b;
        }
        if (question == 91) {
            questaoTextView.setText("De acordo com a Lei nº 8.142/90, os Conselhos de Saúde contam com a representação dos seguintes segmentos:");
            a.setText("gestores de saúde e representantes das associações de moradores");
            b.setText("representantes do governo, de portadores de patologias e do setor privado");
            c.setText("representantes do governo, de portadores de patologias e do setor privado");
            d.setText("representantes do governo, prestadores de serviços, profissionais de saúde e usuários");
            e.setText("gestores públicos e prestadores de serviços");
            alt = R.id.d;
        }
        if (question == 92) {
            questaoTextView.setText("Regionalização do Sistema de Saúde significa organização por");
            a.setText("programas específicos por patologias");
            b.setText("áreas geográficas distintas");
            c.setText("critérios de vigilância epidemiológica");
            d.setText("níveis diferentes de gestão");
            e.setText("níveis de complexidade tecnológica");
            alt = R.id.b;
        }
        if (question == 93) {
            questaoTextView.setText("Compõem a equipe mínima de Saúde da Família:");
            a.setText("médico, enfermeiro, psicólogo e agente comunitário de saúde");
            b.setText("enfermeiro, dentista, psicólogo e auxiliar ou técnico de enfermagem");
            c.setText("médico, enfermeiro, dentista e auxiliar ou técnico de enfermagem");
            d.setText("médico, dentista, psicólogo e agente comunitário de saúde");
            e.setText("médico, enfermeiro, auxiliar ou técnico de enfermagem e agente comunitário de saúde");
            alt = R.id.e;
        }
        if (question == 94) {
            questaoTextView.setText("A Atenção Básica tem como princípio");
            a.setText("ser a porta de entrada preferencial do paciente na rede assistencial de saúde");
            b.setText("priorizar ações curativas em detrimento das ações de promoção da saúde");
            c.setText("prover assistência em grandes hospitais gerais e especializados");
            d.setText("ser local de referência para assistência em nível terciário");
            e.setText("desenvolver ações apenas nas unidades de saúde");
            alt = R.id.a;
        }
        if (question == 95) {
            questaoTextView.setText("Segundo a Lei nº 8.080, de 19 de setembro de 1990, são princípios do SUS, EXCETO:");
            a.setText("universalidade de acesso aos serviços de saúde");
            b.setText("ordenação da formação de recursos humanos");
            c.setText("integralidade da assistência");
            d.setText("participação da comunidade");
            e.setText("descentralização político-administrativa");
            alt = R.id.b;
        }
        if (question == 96) {
            questaoTextView.setText("Segundo os princípios e diretrizes do SUS, qual das unidades listadas a seguir deve ser a porta de entrada preferencial e a referência do cidadão no sistema de saúde?");
            a.setText("Laboratório de Saúde Pública");
            b.setText("Hospital");
            c.setText("Centro de Especialidades");
            d.setText("Unidade Básica de Saúde");
            e.setText("Serviço deApoio Diagnóstico e Terapêutico");
            alt = R.id.d;
        }
        if (question == 97) {
            questaoTextView.setText("A taxa de incidência de sarampo em um município estima o risco de:");
            a.setText("as pessoas acometidas pela doença virem a falecer.");
            b.setText("as pessoas acometidas pela doença apresentarem sequelas permanentes.");
            c.setText("seus habitantes contraírem a doença.");
            d.setText("seus habitantes falecerem por causa da doença.");
            e.setText("se identificar todos os casos da doença existentes na população.");
            alt = R.id.c;
        }
        if (question == 98) {
            questaoTextView.setText("O denominador da taxa de mortalidade geral é constituído por:");
            a.setText("população");
            b.setText("nascidos vivos");
            c.setText("mortes");
            d.setText("pessoas doentes");
            e.setText("natimortos");
            alt = R.id.a;
        }
        if (question == 99) {
            questaoTextView.setText("Assinale a alternativa que apresenta uma medida de prevenção primária segundo o modelo da história natural da doença .");
            a.setText("Iniciar antibiótico para paciente com pneumonia.");
            b.setText("Realizar cirurgia em paciente com apendicite");
            c.setText("Instituir um programa antitabagismo para funcionários.");
            d.setText("Proporcionar atendimento fisioterápico em pacientes que tiveramAVC.");
            e.setText("Oferecer reabilitação cardíaca para pessoas que tiveram infarto do miocárdio.");
            alt = R.id.c;
        }
        if (question == 100) {
            questaoTextView.setText("Segundo a Portaria nº 2.472, de 31de agosto de 2010, do Ministério da Saúde, são doenças que fazem parte da Lista de Notificação Compulsória, EXCETUANDO-SE:");
            a.setText("coqueluche");
            b.setText("dengue");
            c.setText("hepatites virais");
            d.setText("tuberculose");
            e.setText("varicela");
            alt = R.id.e;
        }
        if (question == 101) {
            questaoTextView.setText("O Sistema Único de Saúde SUS conta, em cada esfera do governo, sem prejuízo das funções do Poder Legislativo, com as seguintes instâncias colegiadas:");
            a.setText("Assembleia Deliberativa de Usuários e Comissão Gestora de Saúde.");
            b.setText("Comissão Gestora de Saúde e Conselho de Saúde.");
            c.setText("Conselho de Saúde e Assembleia Deliberativa de Usuários.");
            d.setText("Comissão Gestora de Saúde e Conferência de Saúde.");
            e.setText("Conferência de Saúde e Conselho de Saúde.");
            alt = R.id.e;
        }
        if (question == 102) {
            questaoTextView.setText("O repasse direto e automático de recursos para a cobertura das ações e serviços de saúde a serem implementados pelos Municípios está condicionado ao cumprimento de algumas exigências, entre elas: ");
            a.setText("a contrapartida de recursos para a saúde no respectivo orçamento.");
            b.setText("o estabelecimento de acordo de compra e venda de serviços.");
            c.setText("o comprovado crescimento de suas populações.");
            d.setText("a identificação das diferenças entre as diversas regiões.");
            e.setText("a celebração de convênio entre os órgãos executivos.");
            alt = R.id.a;
        }
        if (question == 103) {
            questaoTextView.setText("NÃO compõem o Conselho Municipal de Saúde os representantes:");
            a.setText("do governo");
            b.setText("dos prestadores de serviço");
            c.setText("dos profissionais de saúde");
            d.setText("das indústrias biomédicas");
            e.setText("dos usuários");
            alt = R.id.d;
        }
        if (question == 104) {
            questaoTextView.setText("Os recursos federais destinados às ações e aos serviços de saúde são organizados e transferidos na forma de blocos de financiamento. Assinale a alternativa que NÃO apresenta um desses blocos.");
            a.setText("Atenção Básica");
            b.setText("Atenção de Média e Alta Complexidade Ambulatorial e Hospitalar");
            c.setText("Vigilância em Saúde");
            d.setText("Assistência Farmacêutica");
            e.setText("Atenção à Saúde do Trabalhador");
            alt = R.id.e;
        }
        if (question == 105) {
            questaoTextView.setText("De acordo com a Lei nº 8.080/90, a iniciativa privada poderá participar do Sistema Único de Saúde (SUS) em caráter complementar. Com relação a essa participação, marque a alternativa correta.");
            a.setText("A preferência de participação é das entidades com fins lucrativos.");
            b.setText("Os valores para a remuneração dos serviços comprados serão arbitrados pelo Secretário de Saúde e sua equipe.");
            c.setText("A participação complementar dos serviços privados será formalizada mediante contrato ou convênio.");
            d.setText("Os serviços contratados não se submetem aos princípios e diretrizes do SUS.");
            e.setText("O gestor estadual poderá recorrer aos serviços ofertados pela iniciativa privada mesmo que tenha disponibilidade suficiente para atender à população.");
            alt = R.id.c;
        }
        if (question == 106) {
            questaoTextView.setText("O termo “universalização da saúde” é compreendido como:");
            a.setText("unificação das medidas preventivas e curativas.");
            b.setText("extensão do direito de assistência à saúde para toda a população.");
            c.setText("aplicação das medicinas alternativas no atendimento médico.");
            d.setText("abordagem compreensiva dos problemas de saúde.");
            e.setText("tratar os diferentes universos da saúde em conformidade com a vontade da comunidade.");
            alt = R.id.b;
        }
        if (question == 107) {
            questaoTextView.setText("Marque a alternativa que apresenta uma das diretrizes para a implementação da Política Nacional de Humanização da Atenção e Gestão do SUS (HumanizaSUS).");
            a.setText("Reduzir o diálogo entre os trabalhadores e a administração.");
            b.setText("Adequar os ambientes com foco nas necessidades dos trabalhadores.");
            c.setText("Respeitar a privacidade do usuário e promover um ambiente acolhedor.");
            d.setText("Estimular ações intervencionistas desnecessárias.");
            e.setText("Promover o atendimento aos usuários segundo a ordem de chegada.");
            alt = R.id.c;
        }
        if (question == 108) {
            questaoTextView.setText("Na Constituição Federal, promulgada em 1988, há um capítulo que define a Seguridade Social como abrangendo as áreas de Saúde, Previdência Social e Assistência Social. Nesse capítulo, a saúde é definida como: ");
            a.setText("ausência de doença, resultante de adequada atenção à saúde.");
            b.setText("direito de cidadania, garantido mediante políticas sociais e econômicas.");
            c.setText("a garantia de oferta de serviços, suficiente para suprir a demanda.");
            d.setText("o equilíbrio corporal, assegurado pelas medidas de prevenção.");
            e.setText("o estado de completo bem-estar físico, psíquico e social.");
            alt = R.id.b;
        }
        if (question == 109) {
            questaoTextView.setText("São princípios e diretrizes do Sistema Único de Saúde, EXCETO:");
            a.setText("equidade");
            b.setText("integralidade");
            c.setText("gratuidade");
            d.setText("regionalização");
            e.setText("universalidade");
            alt = R.id.c;
        }
        if (question == 110) {
            questaoTextView.setText("A participação da comunidade na gestão do Sistema Único de Saúde é regulamentada pelo seguinte dispositivo:");
            a.setText("NOB 1993.");
            b.setText("Lei nº 8.080/1990.");
            c.setText("NOAS 01/2002.");
            d.setText("Lei nº 8.142/1990.");
            e.setText("RDC nº 50/2002.");
            alt = R.id.d;
        }
        if (question == 111) {
            questaoTextView.setText("O Conselho Estadual de Saúde é um órgão colegiado que conta com os seguintes representantes, EXCETO:");
            a.setText("do Governo.");
            b.setText("dos prestadores de serviço.");
            c.setText("dos profissionais de saúde.");
            d.setText("das indústrias de tecnologia em saúde.");
            e.setText("dos usuários.");
            alt = R.id.d;
        }
        if (question == 112) {
            questaoTextView.setText("É uma ação de promoção da saúde, segundo o modelo de História Natural da Doença:");
            a.setText("educação sanitária");
            b.setText("vacinação");
            c.setText("tratamento medicamentoso");
            d.setText("procedimento cirúrgico");
            e.setText("reabilitação");
            alt = R.id.a;
        }
        if (question == 113) {
            questaoTextView.setText("Quando, no Estado, temos um aumento do número de casos novos de uma doença que ocorre de forma brusca, temporária e acima do esperado, estamos diante de uma:");
            a.setText("progressão");
            b.setText("pandemia");
            c.setText("endemia");
            d.setText("erradicação");
            e.setText("epidemia");
            alt = R.id.e;
        }
        if (question == 114) {
            questaoTextView.setText("A Lei n° 8.080/90 dispõe, entre outras coisas, sobre as condições para a promoção, proteção e recuperação da saúde e regula as ações de saúde em todo território nacional. Considerando o exposto acima, analise as afirmativas a seguir e marque a alternativa correta.");
            a.setText("A garantia da saúde pelo Estado deve se dar através da execução de políticas essencialmente econômicas que garantam o acesso igualitário aos serviços de saúde.");
            b.setText("O campo de atuação do SUS é direcionado para a saúde, não incluindo portanto, a colaboração na proteção do meio ambiente.");
            c.setText("As ações do SUS incluem a participação no controle e na fiscalização da produção, transporte, guarda e utilização de substâncias e produtos psicoativos, tóxicos e radioativos.");
            d.setText("Aeducação e a moradia, embora importantes, não são consideradas fatores determinantes e/ou condicionantes da saúde.");
            e.setText("A duplicidade de meios para fins idênticos faz parte da organização dos serviços públicos de saúde visando a integralidade da assistência.");
            alt = R.id.c;
        }
        if (question == 115) {
            questaoTextView.setText("De acordo com a Constituição Federal, são competências do Sistema Único de Saúde, EXCETO:");
            a.setText("controlar e fiscalizar procedimentos, produtos e substâncias de interesse para a saúde e participar da produção de medicamentos, equipamentos, imunobiológicos, hemoderivados e outros insumos.");
            b.setText("fiscalizar e inspecionar alimentos, compreendido o controle de seu teor nutricional, bem como bebidas e água para consumo humano.");
            c.setText("executar ações de vigilância sanitária e epidemiológica, bem como as de saúde do trabalhador.");
            d.setText("participar da formulação da política e da execução das ações de saneamento básico.");
            e.setText("regulamentar a saúde suplementar através de medidas que envolvem a criação de normas, o controle e a fiscalização, assegurando assim o interesse público.");
            alt = R.id.e;
        }
        if (question == 116) {
            questaoTextView.setText("O “Sanitarismo Campanhista” é um modelo assistencial que teve grande importância no enfrentamento dos problemas de saúde no Brasil. Em relação a esse modelo, marque a alternativa correta.");
            a.setText("Encarna a saúde pública tradicional desenvolvida desde o início do século, visando o combate às grandes endemias.");
            b.setText("Surgiu com a urbanização e a industrialização aceleradas que ocorreram no Brasil nos anos 20/30");
            c.setText("Desenvolveu-se a partir e no interior do sistema previdenciário – IAP's, INPS e INAMPS.");
            d.setText("Assistia, inicialmente, apenas às famílias e aos trabalhadores  inserido s  formal e reconhecidamente no mercado de trabalho.");
            e.setText("Sua lógica ajustava-se e valorizava o sistema industrial que necessitava de trabalhadores em condições de trabalhar.");
            alt = R.id.a;
        }
        if (question == 117) {
            questaoTextView.setText("Conforme a Portaria nº 104, de 25 de janeiro de 2011, marque a alternativa que corresponde a uma doença de Notificação Compulsória em Unidades Sentinelas – LNCS");
            a.setText("Lúpus");
            b.setText("Rotavírus");
            c.setText("Osteoporose");
            d.setText("Diabetes");
            e.setText("Herpes");
            alt = R.id.b;
        }
        if (question == 118) {
            questaoTextView.setText("De acordo com a Portaria nº 104, de 25 de janeiro de 2011 que define, entre outras coisas, a relação de doenças, agravos e eventos em saúde pública de notificação compulsória em todo o território nacional, marque a alternativa que corresponde a uma doença da “Lista de Notificação Compulsória Imediata” (LNCI)");
            a.setText("Hanseníase");
            b.setText("Tuberculose");
            c.setText("Malária");
            d.setText("Sífilis");
            e.setText("Botulismo");
            alt = R.id.e;
        }
        if (question == 119) {
            questaoTextView.setText("As ações e serviços de saúde no âmbito do SUS devem ser desenvolvidos de acordo com os princípios e diretrizes previstos na Constituição Federal e na Lei n° 8.080/90. Em relação a estes princípios e diretrizes, é INCORRETO afirmar que:");
            a.setText("a universalidade de acesso aos serviços de saúde deve ocorrer em níveis específicos da assistência.");
            b.setText("a epidemiologia deve ser usada para o estabelecimento de prioridades, alocação de recursos e orientação programática.");
            c.setText("a igualdade da assistência à saúde deve se dar sem preconceitos ou privilégios de qualquer espécie.");
            d.setText("os serviços públicos devem ser organizados de modo a evitar duplicidade de meios para fins idênticos.");
            e.setText("a regionalização e hierarquização da rede de serviços de saúde faz parte da descentralização político-administrativa.");
            alt = R.id.a;
        }
        if (question == 120) {
            questaoTextView.setText("O estudo epidemiológico das doenças envolve o conhecimento das medidas de ocorrência dessas doenças em uma determinada população e período. Com base nesse conhecimento, marque a alternativa na qual o conceito é apresentado de forma correta.");
            a.setText("Incidência - é o número de casos reincidentes de uma doença em um determinado período.");
            b.setText("Prevalência - é a frequência de casos existentes de uma doença em uma determinada população e em um dado momento.");
            c.setText("Morbidade - representa o risco ou probabilidade que qualquer pessoa na população apresenta de vir a morrer em decorrência de uma determinada doença.");
            d.setText("Letalidade - refere-se ao risco de adquirir uma determinada doença num dado intervalo de tempo.");
            e.setText("Mortalidade - representa a proporção de casos fatais em relação ao total de casos verificados de uma determinada doença ou agravo.");
            alt = R.id.b;
        }
        if (question == 121) {
            questaoTextView.setText("A presença usual de uma doença dentro dos limites esperados, em uma determinada área geográfica, por um período de tempo ilimitado, refere-se à:");
            a.setText("epidemia ");
            b.setText("pandemia ");
            c.setText("surto ");
            d.setText("endemia ");
            e.setText("surto epidêmico ");
            alt = R.id.d;
        }
        if (question == 122) {
            questaoTextView.setText("No que diz respeito à participação da comunidade na gestão do Sistema Único de Saúde (SUS), é correto afirmar que: ");
            a.setText("os líderes comunitários devem promover eleições locais para escolher quem representará a comunidade na gestão do SUS. ");
            b.setText("dar-se-á através dos Conselhos e das Conferências de Saúde e será paritária em relação ao conjunto dos demais segmentos. ");
            c.setText("os representantes da comunidade serão nomeados pelas autoridades constituídas. ");
            d.setText("não é relevante já que não está prevista na Constituição e não tem respaldo legal. ");
            e.setText("dar-se-á por meio dos comitês permanentes mediante a ocorrência de um fato relevante para a saúde pública. ");
            alt = R.id.b;
        }
        if (question == 123) {
            questaoTextView.setText("Em relação aos objetivos e atribuições do Sistema Único de Saúde previstos na Lei Federal n° 8.080/90, marque a opção correta. ");
            a.setText("A saúde do trabalhador e a assistência farmacêutica são ações que estão incluídas no campo de atuação do SUS. ");
            b.setText("A participação na execução de ações de saneamento básico não faz parte das atribuições do SUS. ");
            c.setText("A saúde suplementar é uma área prioritária no campo de atuação do Sistema Único de Saúde ");
            d.setText("A vigilância ambiental, embora não esteja diretamente ligada ao SUS, atua em parceria com este, em busca de objetivos comuns ");
            e.setText("Não se incluem no campo de atuação do SUS a fiscalização e a inspeção de alimentos, água e bebidas para consumo humano. ");
            alt = R.id.a;
        }
        if (question == 124) {
            questaoTextView.setText("De acordo com Portaria nº 104, de 25 de janeiro de 2011, marque a alternativa que apresenta uma doença da Lista de Notificação Compulsória em Unidades Sentinela  LNCS. ");
            a.setText("Sarampo ");
            b.setText("Influenza humana ");
            c.setText("Rubéola ");
            d.setText("Varíola ");
            e.setText("Meningite viral ");
            alt = R.id.b;
        }
        if (question == 125) {
            questaoTextView.setText("s Indicadores de Saúde são medidas-síntese que contêm informações relevantes sobre determinados atributos e dimensões do estado de saúde, bem como do desempenho do sistema de saúde. Em relação à Taxa de Mortalidade Infantil, é correto afirmar que: ");
            a.setText("relaciona o nº de óbitos na idade de 7 a 27 dias e o nº de nascidos vivos no período. ");
            b.setText("nesse indicador, o numerador será o total de óbitos no período e o denominador os óbitos na idade de 0 a 6 dias. ");
            c.setText("pode ser medida pela proporção de óbitos de menores de um ano com relação ao total de óbitos do período. ");
            d.setText("a taxa de mortalidade infantil inclui apenas os óbitos ocorridos nos primeiros 6 meses de vida. ");
            e.setText("para o cálculo desse indicador, não são considerados os óbitos ocorridos antes do primeiro mês de vida. ");
            alt = R.id.c;
        }
        if (question == 126) {
            questaoTextView.setText("A participação da comunidade no Sistema Único de Saúde está prevista na legislação e se dá através dos Conselhos e Conferências de Saúde. No que se refere aos Conselhos de Saúde, é correto afirmar que: ");
            a.setText("devem ser representados apenas por profissionais da saúde e prestadores de serviços. ");
            b.setText("nos Conselhos Municipais é obrigatória a presença de um representante do Governo Federal. ");
            c.setText("os representantes de associação de moradores não fazem parte dos Conselhos Estaduais. ");
            d.setText("devem ser compostos apenas de representantes comunitários e representantes de portadores de deficiência. ");
            e.setText("o Conselho Estadual deve conter, entre outros, representantes de entidades de defesa do consumidor. ");
            alt = R.id.e;
        }
        if (question == 127) {
            questaoTextView.setText("O SIH/SUS foi concebido para operar o sistema de pagamento de internação aos hospitais contratados pelo Ministério da Previdência. Em 1986, foi estendido aos hospitais filantrópicos; em 1987, aos universitários e de ensino; e, em 1991, aos hospitais públicos municipais, estaduais e federais. Em relação a esse sistema, marque a opção correta. ");
            a.setText("É o sistema responsável pela captação e processamento das contas ambulatoriais do SUS. ");
            b.setText("Tem como objetivo coletar, transmitir e disseminar dados gerados, rotineiramente, pelo Sistema de Vigilância Epidemiológica. ");
            c.setText("É o mais antigo Sistema de Informação de Saúde em funcionamento no País. ");
            d.setText("Seu documento básico é a AIH, que habilita a internação do paciente e gera valores para pagamento. ");
            e.setText("Coleta informações relacionadas ao planejamento, acompanhamento e avaliação das atividades dosAgentes Comunitários de Saúde. ");
            alt = R.id.d;
        }
        if (question == 128) {
            questaoTextView.setText("As responsabilidades da União, dos Estados, do Distrito Federal e dos Municípios em relação ao rol de ações e serviços constantes da Relação Nacional de Ações e Serviços de Saúde – RENASES – serão pactuadas nas(os) respectivas(os): ");
            a.setText("Conferências de Saúde ");
            b.setText("Conselhos de Saúde ");
            c.setText("Comissões Intergestores ");
            d.setText("Reuniões extraordinárias ");
            e.setText("Comitês de Saúde ");
            alt = R.id.c;
        }
        if (question == 129) {
            questaoTextView.setText("Em relação ao Planejamento de Saúde, é INCORRETO afirmar: ");
            a.setText("No âmbito estadual, deve ser realizado de maneira regionalizada, em função das necessidades dos municípios, considerando o estabelecimento de metas de saúde. ");
            b.setText("O Mapa da Saúde será utilizado na identificação das necessidades de saúde e orientará o planejamento integrado dos entes federativos. ");
            c.setText("É um processo obrigatório para os entes públicos e será indutor de políticas para a iniciativa privada. ");
            d.setText("Compete à Comissão Intergestores Tripartite – CIT pactuar as etapas do processo e os prazos do planejamento municipal. ");
            e.setText("O Conselho Nacional de Saúde estabelecerá as diretrizes a serem observadas na elaboração dos planos de saúde. ");
            alt = R.id.d;
        }
        if (question == 130) {
            questaoTextView.setText("O Pacto pela Saúde é um conjunto de reformas institucionais que têm o objetivo de promover inovações nos processos e instrumentos de gestão e compreende três dimensões: o Pacto pela Vida, o Pacto de Gestão e o Pacto em Defesa do SUS. No que se refere ao Pacto de Gestão, assinale a opção correta. ");
            a.setText("É constituído por um conjunto de compromissos sanitários, expressos em objetivos e metas, derivados da análise da situação de saúde da população e das prioridades definidas pelos governos federal, estaduais e municipais. ");
            b.setText("Tem como objetivos a redução da mortalidade infantil e materna, a atenção integral a pessoas em situação ou risco de violência e o fortalecimento da capacidade de resposta às doenças emergentes e endemias, com ênfase na dengue e hanseníase. ");
            c.setText("Avança na regionalização e descentralização do SUS, a partir da proposição de algumas diretrizes, permitindo uma diversidade operativa que respeite as singularidades regionais. ");
            d.setText("Representa o compromisso inequívoco com a repolitização do SUS, consolidando a política pública de saúde brasileira como uma política de Estado, mais do que uma política de governos. ");
            e.setText("Tem como uma das prioridades implementar um projeto permanente de mobilização social com a finalidade de demonstrar a saúde como direito de cidadania e o SUS como sistema público universal garantidor desse direito. ");
            alt = R.id.c;
        }
        if (question == 131) {
            questaoTextView.setText("Assinale a opção que faz parte da Lista de Notificação Compulsória Imediata – LNCI. ");
            a.setText("lúpus ");
            b.setText("herpes ");
            c.setText("diabetes ");
            d.setText("malária ");
            e.setText("difteria ");
            alt = R.id.e;
        }
        if (question == 132) {
            questaoTextView.setText("O Sistema Único de Saúde – SUS faz parte das ações definidas na Constituição Federal (CF) como sendo de “relevância pública”. A respeito do que dispõe a CF sobre o SUS, analise as afirmativas abaixo e marque a opção correta. ");
            a.setText("Não compete ao Sistema Único de Saúde participar da formulação da política e da execução das ações de saneamento básico. ");
            b.setText("Em nenhuma hipótese será permitida a participação direta ou indireta de empresas ou capitais estrangeiros na assistência à saúde no País. ");
            c.setText("Poderão ser destinados recursos públicos para auxílios ou subvenções às instituições privadas com fins lucrativos. ");
            d.setText("As entidades filantrópicas e as sem fins lucrativos terão preferência quando da participação complementar de instituições privadas no SUS ");
            e.setText("Colaborar na proteção do meio ambiente, nele compreendido o do trabalho, não é uma atribuição direta do SUS. ");
            alt = R.id.d;
        }
        if (question == 133) {
            questaoTextView.setText("Em 1933, foi criado o primeiro Instituto de Aposentadoria e Pensões, o dos Marítimos (IAPM). Um dos benefícios assegurados aos associados foi assistência médica e hospitalar com internação até: ");
            a.setText("10 dias ");
            b.setText("15 dias ");
            c.setText("20 dias ");
            d.setText("30 dias ");
            e.setText("40 dias ");
            alt = R.id.d;
        }
        if (question == 134) {
            questaoTextView.setText("A respeito das Regiões de Saúde, regulamentadas pelo Decreto nº 7.508/2011, assinale a assertiva correta. ");
            a.setText("As Regiões de Saúde serão referência para as transferências de recursos entre os entes federativos. ");
            b.setText("Os Municípios serão responsáveis por instituir as Regiões de Saúde, em articulação com os Estados. ");
            c.setText("A instituição das Regiões de Saúde observará cronograma pactuado nos Conselhos de Saúde. ");
            d.setText("As Regiões de Saúde estarão compreendidas no âmbito de uma Rede deAtenção à Saúde. ");
            e.setText("Poderão ser instituídas Regiões de Saúde inter-regionais, compostas por Estados limítrofes. ");
            alt = R.id.a;
        }
        if (question == 135) {
            questaoTextView.setText("Em relação ao planejamento da saúde, analise as alternativas abaixo e marque a opção INCORRETA. ");
            a.setText("O Mapa da Saúde será utilizado na identificação das necessidades de saúde e orientará o planejamento integrado dos entes federativos. ");
            b.setText("A Comissão Intergestores Bipartite estabelecerá as diretrizes a serem observadas na elaboração dos planos de saúde. ");
            c.setText("O planejamento da saúde é obrigatório para os entes públicos e será indutor de políticas para a iniciativa privada. ");
            d.setText("O planejamento da saúde em âmbito estadual deve ser realizado de maneira regionalizada, com base nas necessidades dos Municípios. ");
            e.setText("No planejamento, devem ser considerados os serviços e as ações prestados pela iniciativa privada, de forma complementar ou não ao SUS. ");
            alt = R.id.b;
        }
        if (question == 136) {
            questaoTextView.setText("Marque a opção que apresenta uma doença ou agravo da Lista de Notificação Compulsória em Unidades Sentinelas – LNCS. ");
            a.setText("Botulismo ");
            b.setText("Meningites virais ");
            c.setText("Raiva humana ");
            d.setText("Influenza humana ");
            e.setText("Sarampo ");
            alt = R.id.d;
        }
        if (question == 137) {
            questaoTextView.setText("A “taxa de internação hospitalar por causas externas” é acompanhada pelo Ministério da Saúde e classificada como um indicador: ");
            a.setText("de mortalidade ");
            b.setText("socioeconômico ");
            c.setText("de cobertura ");
            d.setText("de morbidade ");
            e.setText("demográfico ");
            alt = R.id.d;
        }
        if (question == 138) {
            questaoTextView.setText("As autorizações de internação hospitalar (AIH) são formulários que contêm os dados utilizados para alimentar o seguinte sistema: ");
            a.setText("Sistema de Informações de Mortalidade. ");
            b.setText("Sistema de Informações de Nascidos-vivos. ");
            c.setText("Sistema de Notificação de Agravos. ");
            d.setText("Sistema de Informações Ambulatoriais. ");
            e.setText("Sistema de Informações Hospitalares. ");
            alt = R.id.e;
        }
        if (question == 139) {
            questaoTextView.setText("De acordo com as normas estabelecidas pelo Ministério da Saúde, a pactuação das etapas e dos prazos do planejamento municipal é uma competência do(a): ");
            a.setText("Conselho Nacional de Saúde ");
            b.setText("Conselho Municipal de Saúde ");
            c.setText("Comissão Intergestores Tripartite ");
            d.setText("Comissão Intergestores Regional ");
            e.setText("Comissão Intergestores Bipartite ");
            alt = R.id.e;
        }
        if (question == 140) {
            questaoTextView.setText("Marque a opção que indica uma competência da Direção Nacional do SUS. ");
            a.setText("Controlar e fiscalizar procedimentos, produtos e substâncias de interesse para a saúde. ");
            b.setText("Identificar estabelecimentos hospitalares de referência. ");
            c.setText("Controlar e fiscalizar os procedimentos dos serviços privados de saúde. ");
            d.setText("Dar execução, no âmbito municipal, à política de insumos e equipamentos para a saúde. ");
            e.setText("Acompanhar, controlar e avaliar as redes hierarquizadas do Sistema Único de Saúde. ");
            alt = R.id.a;
        }
        if (question == 141) {
            questaoTextView.setText("Os casos de febre amarela, óbito por dengue e cólera devem ser notificados às Secretarias Estaduais e Municipais de Saúde (SES e SMS) em, no máximo, quanto tempo a partir da suspeita inicial? ");
            a.setText("36 horas ");
            b.setText("48 horas ");
            c.setText("24 horas ");
            d.setText("72 horas ");
            e.setText("96 horas ");
            alt = R.id.c;
        }
        if (question == 142) {
            questaoTextView.setText("A unificação dos IAPs, no contexto do regime autoritário de 1964, resultou na criação do: ");
            a.setText("Instituto Nacional de Previdência Social (INPS). ");
            b.setText("Sistema Nacional de Assistência e Previdência Social (SINPAS). ");
            c.setText("Programa deAções Integradas de Saúde (PAIS). ");
            d.setText("Instituto Nacional de Assistência Médica da Previdência Social (INAMPS). ");
            e.setText("Sistema Unificado e Descentralizado de Saúde (SUDS). ");
            alt = R.id.a;
        }
        if (question == 143) {
            questaoTextView.setText("Marque a alternativa que corresponde a uma das diretrizes do SUS prevista na Constituição Federal de 1988. ");
            a.setText("Universalidade de acesso ");
            b.setText("Preservação da autonomia ");
            c.setText("Igualdade da assistência ");
            d.setText("Descentralização ");
            e.setText("Regionalização da rede ");
            alt = R.id.d;
        }
        if (question == 144) {
            questaoTextView.setText("O Gestor de Saúde no nível estadual é representado pelo: ");
            a.setText("presidente da comissão de saúde. ");
            b.setText("comissão intergestor bipartite. ");
            c.setText("secretário de planejamento do estado. ");
            d.setText("conselho estadual de saúde. ");
            e.setText("secretário estadual de saúde. ");
            alt = R.id.e;
        }
        if (question == 145) {
            questaoTextView.setText("A proteção específica faz parte do nível de prevenção: ");
            a.setText("primordial ");
            b.setText("primária ");
            c.setText("secundária ");
            d.setText("terciária ");
            e.setText("quaternária ");
            alt = R.id.b;
        }
        if (question == 146) {
            questaoTextView.setText("Os conselhos e conferências de saúde garantem o cumprimento do seguinte princípio: ");
            a.setText("integralidade da assistência. ");
            b.setText("equidade ");
            c.setText("participação social ");
            d.setText("hierarquização ");
            e.setText("resolubilidade ");
            alt = R.id.c;
        }
        if (question == 147) {
            questaoTextView.setText("O instrumento de coleta do Sistema de Informação Hospitalar – SIH é o(a): ");
            a.setText("Alteração no Sistema de Pagamento. ");
            b.setText("Guia deAutorização para Internação. ");
            c.setText("Formulário de Procedimentos Hospitalares. ");
            d.setText("Boletim de ProcedimentosAmbulatoriais. ");
            e.setText("Autorização de Internação Hospitalar. ");
            alt = R.id.e;
        }
        if (question == 148) {
            questaoTextView.setText("A Relação Nacional de Ações e Serviços de Saúde – RENASES compreende: ");
            a.setText("a seleção e a padronização de medicamentos indicados para atendimento de doenças ou de agravos no âmbito do SUS. ");
            b.setText("a descrição geográfica da distribuição de recursos humanos e de ações e serviços de saúde, ofertados pelo SUS. ");
            c.setText("todas as ações e serviços que o SUS oferece ao usuário para atendimento da integralidade da assistência à saúde. ");
            d.setText("o acordo de colaboração firmado entre entes federativos com a finalidade de organizar e integrar as ações e serviços de saúde. ");
            e.setText("a normatização e padronização dos termos médico-assistenciais usados nas unidades básicas de saúde. ");
            alt = R.id.c;
        }
        if (question == 149) {
            questaoTextView.setText("As diretrizes a serem observadas na elaboração dos planos de saúde são estabelecidas pelo(a): ");
            a.setText("Secretaria de Planejamento Estratégico. ");
            b.setText("Colegiado de Gestão. ");
            c.setText("Comitê Intergestor de Saúde. ");
            d.setText("Conselho Nacional de Saúde. ");
            e.setText("Secretaria de Atenção à Saúde. ");
            alt = R.id.d;
        }
        if (question == 150) {
            questaoTextView.setText("Os Conselhos de Secretarias Municipais de Saúde (Cosems) são reconhecidos como entidades que representam os entes municipais no âmbito: ");
            a.setText("regional ");
            b.setText("estadual ");
            c.setText("nacional ");
            d.setText("interestadual ");
            e.setText("intermunicipal ");
            alt = R.id.b;
        }
        if (question == 151) {
            questaoTextView.setText("A ocorrência de determinada doença que acomete sistematicamente populações em espaços característicos e determinados, no decorrer de um longo período, denomina-se: ");
            a.setText("endemia ");
            b.setText("surto ");
            c.setText("epidemia ");
            d.setText("pandemia ");
            e.setText("variação cíclica ");
            alt = R.id.a;
        }
        if (question == 152) {
            questaoTextView.setText("O Movimento Sanitarista no Brasil foi conduzido por: ");
            a.setText("Pedro Nava ");
            b.setText("Artur Neiva ");
            c.setText("SérgioArouca ");
            d.setText("Belisário Pena ");
            e.setText("Oswaldo Cruz ");
            alt = R.id.e;
        }
        if (question == 153) {
            questaoTextView.setText("A gerência de laboratórios públicos de saúde e hemocentros é uma competência da: ");
            a.setText("direção estadual do SUS. ");
            b.setText("direção municipal do SUS. ");
            c.setText("comissão intersetorial. ");
            d.setText("vigilância em saúde. ");
            e.setText("direção nacional do SUS. ");
            alt = R.id.b;
        }
        if (question == 154) {
            questaoTextView.setText("A Vigilância da Situação de Saúde é responsável por desenvolver ações: ");
            a.setText("de monitoramento contínuo do país, estado, região, município ou áreas de abrangência de equipes de atenção à saúde. ");
            b.setText("que propiciam o conhecimento e a detecção de mudanças nos fatores determinantes e condicionantes do meio ambiente que interferem na saúde humana. ");
            c.setText("que visam à promoção da saúde e à redução da morbimortalidade da população trabalhadora. ");
            d.setText("capazes de eliminar, diminuir ou prevenir riscos à saúde e de intervir nos problemas sanitários decorrentes dos mais diversos fatores. ");
            e.setText("de vigilância e controle das doenças transmissíveis, não transmissíveis e agravos. ");
            alt = R.id.a;
        }
        if (question == 155) {
            questaoTextView.setText("A taxa de letalidade relaciona: ");
            a.setText("o total de óbitos de um determinado local pela população exposta ao risco de morrer. ");
            b.setText("o número médio de anos que ainda restam para serem vividos por indivíduos de determinada idade. ");
            c.setText("o número de óbitos por determinada causa e o número de pessoas que foram acometidas por tal doença. ");
            d.setText("o coeficiente ou taxa de incidência de uma determinada doença para um grupo determinado de pessoas. ");
            e.setText("o número de casos novos da doença que iniciaram no mesmo local e período e que representam uma epidemia. ");
            alt = R.id.c;
        }
        if (question == 156) {
            questaoTextView.setText("A manifestação de doença ou uma ocorrência que apresente potencial para causar doença é denominada: ");
            a.setText("taxa ");
            b.setText("causa ");
            c.setText("risco ");
            d.setText("agravo ");
            e.setText("evento ");
            alt = R.id.e;
        }
        if (question == 157) {
            questaoTextView.setText("Marque a alternativa que corresponde a uma doença ou agravo de notificação compulsória. ");
            a.setText("Anemia ");
            b.setText("Osteomielite ");
            c.setText("Lúpus ");
            d.setText("Tétano ");
            e.setText("Diabetes ");
            alt = R.id.d;
        }
        if (question == 158) {
            questaoTextView.setText("A meta é um dos componentes essenciais de um: ");
            a.setText("plano diretor. ");
            b.setText("indicador de saúde. ");
            c.setText("plano de saúde. ");
            d.setText("consórcio de saúde. ");
            e.setText("programação pactuada. ");
            alt = R.id.b;
        }
        if (question == 159) {
            questaoTextView.setText("O processo de planejamento da saúde deve ser: ");
            a.setText("ascendente e integrado. ");
            b.setText("independente e horizontalizado. ");
            c.setText("descendente e integrado. ");
            d.setText("ascendente e horizontalizado. ");
            e.setText("independente e verticalizado. ");
            alt = R.id.a;
        }
        if (question == 160) {
            questaoTextView.setText("O índice de envelhecimento é um exemplo de indicador: ");
            a.setText("de recurso. ");
            b.setText("de cobertura. ");
            c.setText("de morbidade. ");
            d.setText("demográfico. ");
            e.setText("socioeconômico. ");
            alt = R.id.d;
        }
        if (question == 161) {
            questaoTextView.setText("A capacidade que o agente infeccioso tem de penetrar e se desenvolver no novo hospedeiro, ocasionando infecção é denominada de: ");
            a.setText("letalidade ");
            b.setText("imunogenicidade ");
            c.setText("virulência ");
            d.setText("patogenicidade ");
            e.setText("infectividade ");
            alt = R.id.e;
        }
        if (question == 162) {
            questaoTextView.setText("Conjunto de ações de saúde, no âmbito individual e coletivo, que abrangem a promoção e a proteção da saúde, a prevenção de agravo, o diagnóstico, o tratamento, a reabilitação, a redução dos danos e a manutenção da saúde com o objetivo de desenvolver uma atenção integral que impacte na situação de saúde das coletividades: ");
            a.setText("Atenção integral de saúde ");
            b.setText("Atenção básica de saúde ");
            c.setText("Atenção integralizada de saúde ");
            d.setText("Atenção primitiva de saúde ");
            e.setText("Atenção à saúde da família ");
            alt = R.id.b;
        }
        if (question == 163) {
            questaoTextView.setText("O Programa Agente Comunitário de Saúde (PACS) existe desde o início dos anos 90, foi efetivamente instituído e regulamentado em 1997, quando se iniciou o processo de consolidação da descentralização de recurso no âmbito do Sistema Único de Saúde (SUS). Hoje é considerado uma estratégia para: ");
            a.setText("O Núcleo de Apoio à Estratégia Saúde da Família. ");
            b.setText("A organização das Unidades Básicas de Saúde. ");
            c.setText("A estratégia Saúde da Família. ");
            d.setText("Pacto de Gestão. ");
            e.setText("Pacto em defesa do Sistema de Saúde. ");
            alt = R.id.c;
        }
        if (question == 164) {
            questaoTextView.setText("Órgão colegiado, deliberativo e permanente do Sistema Único de Saúde (SUS) em cada esfera do governo integrante da estrutura básica do Ministério da Saúde da Secretaria do Estado da Saúde, do Distrito Federal e dos Municípios: ");
            a.setText("Conselho Deliberativo de Saúde ");
            b.setText("Comissão Colegiada de Saúde ");
            c.setText("Conselho Nacional de Deliberação em Saúde ");
            d.setText("Conselho de Saúde ");
            e.setText("Comissão de Diretos Humanos ");
            alt = R.id.d;
        }
        if (question == 165) {
            questaoTextView.setText("É desenvolvido(a) com o(a) mais alto grau de descentralização e capilaridadade, próxima da vida das pessoas, deve ser o contato preferencial dos usuários, a principal porta de entrada e comunicação da rede de atenção à saúde cuja portaria é de nº 2.488 de 21 de outubro de 2011: ");
            a.setText("Estratégia Saúde da Família ");
            b.setText("Pacto pela Saúde ");
            c.setText("Política Nacional de Medicamento ");
            d.setText("Programa de Agente Comunitário de Saúde ");
            e.setText("Política Nacional de Atenção Básica ");
            alt = R.id.e;
        }
        if (question == 166) {
            questaoTextView.setText("Considerando a Lei nº 8.080, de 19 de setembro de 1990, e a lei nº 8.142/90, o Plenário do Conselho Nacional de Saúde (CNS), no uso de suas competências regimentais, aprova as diretrizes para criação, reformulação, estruturação e funcionamento dos Conselhos de Saúde, com poder de decisão, ligada ao poder executivo. Ele é composto por: ");
            a.setText("50% de trabalhadores, 25% de usuários e 25% de prestadores de serviços. ");
            b.setText("50% de prestadores de serviços, 25% de usuários e 25% de trabalhadores. ");
            c.setText("Apenas 50% de trabalhadores e 50% de usuários. ");
            d.setText("50% de usuários e 50% de prestadores de serviços. ");
            e.setText("50% de usuários, 25% de trabalhadores e 25% de prestadores de serviços. ");
            alt = R.id.e;
        }
        if (question == 167) {
            questaoTextView.setText("Segundo a Organização Mundial de Saúde (OMS), saúde é o completo estado de bem estar físico, mental, social e não apenas a ausência de doenças ou enfermidade. A primeira vez que o conceito de saúde foi discutido desta maneira foi na primeira Conferência Internacional sobre Promoção de Saúde, realizada em Ottawa, Canadá, em 1986 que considera: ");
            a.setText("a reforma da saúde como uma base bem sólida para a formação do Sistema Único de Saúde - SUS e do pacto pela vida. ");
            b.setText("a paz, a educação, a alimentação, a renda, o ecossistema saudável, os recursos renováveis, a justiça social e a equidade. ");
            c.setText("apenas a paz, a alimentação, a educação, a habitação com condições adequadas de moradia. ");
            d.setText("apenas alimentação, justiça social e bem-estar social. ");
            e.setText("apenas alimentação, renda e recursos renováveis. ");
            alt = R.id.b;
        }
        if (question == 168) {
            questaoTextView.setText("O Sistema Único de Saúde – SUS é fruto de um longo processo de construção política e institucional chamada de reforma sanitária voltada para transformação das condições de saúde e de atenção à saúde da população brasileira, confirmando a saúde como um direito e dever do Estado, instituído por lei federal, nº 8.080, de 19/09/1990 e a lei nº 8.142, de 18/12/1990, sendo elas o arcabouço para a existência e o funcionamento do SUS que tem como princípios doutrinários: ");
            a.setText("universalidade e participação social e econômica em todo território nacional. ");
            b.setText("apenas universalidade e participação econômica e social. ");
            c.setText("participação dos cidadãos através apenas do Conselho de Saúde, porque são eles que elegem os governantes. ");
            d.setText("participação social, universalidade, equidade. ");
            e.setText("universalidade, equidade, integralidade. ");
            alt = R.id.e;
        }
        if (question == 169) {
            questaoTextView.setText("Representa(m) um espaço responsável pela mobilização e articulação contínua da sociedade, na defesa dos princípios constitucionais e dos dispositivos legais que fundamenta(m) o Sistema Único de Saúde – SUS, funcionando com a participação efetiva da sociedade, reivindicando e fiscalizando o setor saúde, com o objetivo de garantir o direto à saúde integral e universal do cidadão: ");
            a.setText("Ministério de Previdência e Assistência Social ");
            b.setText("Ministério da Saúde ");
            c.setText("Assembleia Legislativa ");
            d.setText("Conselhos de Saúde ");
            e.setText("Conselho Consumidor de Saúde ");
            alt = R.id.d;
        }
        if (question == 170) {
            questaoTextView.setText("O Ministério da Saúde, o Conselho Nacional de Secretarias de Saúde (CONASS) e o Conselho Nacional de Secretarias Municipais de Saúde (CONASEMS) pactuaram responsabilidades entre os três entes de gestão do SUS no campo da gestão do sistema e da atenção à saúde. Constitui o pacto firmado entre os três gestores do SUS com o objetivo de organizar as regiões de saúde. Assim, para sua implementação, esse pacto entre os gestores foi instituído em três dimensões, a saber: ");
            a.setText("Pacto pela vida, pacto de gestão e pacto em defesa do SUS. ");
            b.setText("Pacto pela vida, pacto de assistência emergencial e pacto de municipalização. ");
            c.setText("Pacto pela vida, pacto de regulação e pacto integral de saúde. ");
            d.setText("Pacto pela vida, pacto de atenção integral e pacto de co-gestão. ");
            e.setText("Pacto pela vida, pacto em defesa do SUS e pacto social. ");
            alt = R.id.a;
        }
        if (question == 171) {
            questaoTextView.setText("São fóruns com representação de vários segmentos sociais que se reúnem para propor diretrizes, avaliar a situação da saúde da população e ajudar na definição da política de saúde. Devem ser realizadas(os) em todos os níveis de governo: nacional, estadual e municipal e tem(têm) como função formular estratégias, controlar e avaliar a execução da política de saúde. ");
            a.setText("Conselhos de Saúde ");
            b.setText("Congresso Nacional de Saúde ");
            c.setText("Conferências de Saúde ");
            d.setText("Participação Popular ");
            e.setText("Conselhos Deliberativo do Controle Social ");
            alt = R.id.c;
        }
        if (question == 172) {
            questaoTextView.setText("De acordo com o que dispõe a Resolução 453/2012 do Conselho Nacional da Saúde, as funções como membro dos Conselhos de Saúde ");
            a.setText("não serão remuneradas, considerando-se o seu exercício de relevância pública e, portanto, garante a dispensa do trabalho sem prejuízo para o conselheiro. ");
            b.setText("serão remuneradas, considerando que o seu exercício é de relevância pública, com valor correspondente a 1 salário mínimo por ato praticado pelo conselheiro, limitado este valor ao teto do Regime Geral da Previdência Social. ");
            c.setText("serão remuneradas, considerando que o seu exercício é de relevância pública, quando o conselheiro tiver que ausentar-se do trabalho, oportunidade em que o Estado indenizará o empregador. ");
            d.setText("serão remuneradas com valores suficientes para compensar os dias de trabalho perdidos pelo conselheiro. ");
            e.setText("não serão remuneradas, porque, devido ao seu caráter facultativo e eventual, são exercidas somente aos sábados, domingos e feriados, de modo que não há necessidade de afastamentos ou dispensa do trabalho do conselheiro. ");
            alt = R.id.a;
        }
        if (question == 173) {
            questaoTextView.setText("De acordo com as disposições da Constituição Federal, no que se refere à Saúde, assinale a alternativa correta. ");
            a.setText("A assistência à saúde é privativa da União e sem fins lucrativos, motivo pelo qual é vedada qualquer participação da iniciativa privada, exceto por instituições sem fins lucrativos. ");
            b.setText("As instituições privadas poderão participar de forma complementar do Sistema Único de Saúde, segundo diretrizes deste, somente mediante contrato de direito privado, após procedimento de licitação na modalidade concorrência. ");
            c.setText("É vedada a destinação de recursos públicos para auxílios ou subvenções às instituições privadas com fins lucrativos. ");
            d.setText("É possível e sempre admitida a participação direta ou indireta de empresas ou capitais estrangeiros na assistência à saúde no País. ");
            e.setText("O Poder Público, por meio de Lei Complementar, regulamenta as condições e os requisitos que facilitem a remoção de órgãos, tecidos e substâncias humanas para fins de transplante, pesquisa e tratamento, bem como estabelece as regras que permitem sua comercialização. ");
            alt = R.id.c;
        }
        if (question == 174) {
            questaoTextView.setText("De acordo com as definições trazidas pela Lei Orgânica da Saúde - Lei n° 8.080/1990, a Vigilância Epidemiológica ");
            a.setText("está incluída no campo de atuação do Sistema Único de Saúde e é definida como um conjunto de ações capaz de eliminar, diminuir ou prevenir riscos à saúde e de intervir nos problemas sanitários decorrentes do meio ambiente, da produção e circulação de bens e da prestação de serviços de interesse da saúde. ");
            b.setText("está incluída no campo de atuação do Sistema Único de Saúde e é definida como um conjunto de ações que proporcionam o conhecimento, a detecção ou prevenção de qualquer mudança nos fatores determinantes e condicionantes de saúde individual ou coletiva, com a finalidade de recomendar e adotar as medidas de prevenção e controle das doenças ou agravos. ");
            c.setText("está incluída no campo de atuação do Sistema Único de Saúde e é definida como o controle exercido sobre todos os bens de consumo que, direta ou indiretamente, se relacionem com a saúde, compreendidas todas as etapas e processos, da produção ao consumo. ");
            d.setText("não está incluída no campo de atuação do Sistema Único de Saúde e é definida como um conjunto de ações capaz de eliminar, diminuir ou prevenir riscos à saúde e de intervir nos problemas sanitários decorrentes do meio ambiente, da produção e circulação de bens e da prestação de serviços de interesse da saúde. ");
            e.setText("não está incluída no campo de atuação do Sistema Único de Saúde e é definida como o controle exercido sobre todos os bens de consumo que, direta ou indiretamente, se relacionem com a saúde, compreendidas todas as etapas e processos, da produção ao consumo. ");
            alt = R.id.b;
        }
        if (question == 175) {
            questaoTextView.setText("De acordo com o que dispõe a Lei 8.142/90, a Conferência de Saúde é uma instância ");
            a.setText("singular; presente apenas no âmbito municipal; reunir-se-á a cada dois anos com a representação dos vários segmentos sociais, para avaliar a situação de saúde e propor as diretrizes para a formulação da política de saúde. ");
            b.setText("colegiada; presente apenas no âmbito municipal; reunir-se-á a cada dois anos com a representação dos vários segmentos sociais, para avaliar a situação de saúde e propor as diretrizes para a formulação da política de saúde. ");
            c.setText("ingular; presente apenas no âmbito federal; reunir-se-á a cada dois anos com a representação dos vários segmentos sociais, para avaliar a situação de saúde e propor as diretrizes para a formulação da política de saúde. ");
            d.setText("colegiada; presente em cada esfera de governo; reunir-se-á a cada quatro anos com a representação dos vários segmentos sociais, para avaliar a situação de saúde e propor as diretrizes para a formulação da política de saúde nos níveis correspondentes. ");
            e.setText("presente apenas em âmbito estadual e federal; reunir-se-á a cada quatro anos com a representação dos vários segmentos sociais, para avaliar a situação de saúde e propor as diretrizes para a formulação da política de saúde nos níveis correspondentes. ");
            alt = R.id.d;
        }
        if (question == 176) {
            questaoTextView.setText("De acordo com as denominações expostas no Decreto Presidencial nº 7.508, de 28 de junho de 2011, considera-se Portas de Entrada: ");
            a.setText("as instâncias de pactuação consensual entre os entes federativos para definição das regras da gestão compartilhada do SUS. ");
            b.setText("o conjunto de ações e serviços de saúde articulados em níveis de complexidade crescente, com a finalidade de garantir a integralidade da assistência à saúde. ");
            c.setText("a descrição geográfica da distribuição de recursos humanos e de ações e serviços de saúde ofertados pelo SUS e pela iniciativa privada. ");
            d.setText("os serviços de saúde específicos para o atendimento da pessoa que, em razão de agravo ou de situação laboral, necessita de atendimento especial. ");
            e.setText("os serviços de atendimento inicial à saúde do usuário no SUS. ");
            alt = R.id.e;
        }
        if (question == 177) {
            questaoTextView.setText("Com relação às disposições da Lei n° 8.080/90 referentes à Saúde do Trabalhador, assinale a alternativa correta. ");
            a.setText("O Sistema Único de Saúde não se responsabiliza pela informação ao trabalhador, à sua respectiva entidade sindical e às empresas sobre os riscos de acidentes de trabalho, doença profissional e do trabalho, ficando essas informações a cargo das instituições privadas. ");
            b.setText("A partir da homologação dessa lei, a avaliação do impacto que as novas tecnologias provocam à saúde ficaram a cargo do Ministério da Ciência e Tecnologia e suas representações estaduais. ");
            c.setText("A direção municipal do Sistema Único de Saúde deve indicar a entidade sindical responsável pela revisão periódica da listagem oficial de doenças originadas no processo de trabalho. ");
            d.setText("As políticas de saúde do trabalhador incluem a responsabilidade na formação dos recursos humanos, promovendo cursos de reciclagem e garantindo sua satisfação no trabalho. ");
            e.setText("Devem ser desenvolvidas atividades voltadas à recuperação e reabilitação da saúde dos trabalhadores submetidos aos riscos e agravos advindos das condições de trabalho. ");
            alt = R.id.e;
        }
        if (question == 178) {
            questaoTextView.setText("São princípios do Sistema Único de Saúde (SUS) que constam na Lei 8080/90: ");
            a.setText("centralização, universalidade e integralidade. ");
            b.setText("hierarquização, centralização e integralidade. ");
            c.setText("universalidade, igualdade e integralidade. ");
            d.setText("universalidade, participação popular e autonomia. ");
            e.setText("integralidade, participação popular e autonomia. ");
            alt = R.id.c;
        }
        if (question == 179) {
            questaoTextView.setText("À direção municipal do Sistema Único de Saúde, conforme a Lei n° 8080/90, compete: ");
            a.setText("executar as ações de vigilância sanitária em relação às fronteiras internacionais. ");
            b.setText("planejar, organizar, controlar e avaliar as ações e serviços de saúde, como gerir e executar os serviços públicos de saúde. ");
            c.setText("planejar, executar e gerir os laboratórios de análises de produtos farmacológicos e os hemocentros. ");
            d.setText("participar e gerir a programação de serviços de saúde no âmbito estadual. ");
            e.setText("programar e coordenar as campanhas estaduais de vacinação. ");
            alt = R.id.b;
        }
        if (question == 180) {
            questaoTextView.setText("Qual dos princípios abaixo NÃO faz parte da Lei Orgânica de Saúde nº 8.080/90? ");
            a.setText("Integralidade ");
            b.setText("Universalidade ");
            c.setText("Igualdade ");
            d.setText("Centralização ");
            e.setText("Direito à informação, das pessoas assistidas, sobre sua saúde. ");
            alt = R.id.d;
        }
        if (question == 181) {
            questaoTextView.setText("O principal propósito é reorganizar a prática da atenção à saúde em novas bases e substituir o modelo tradicional, levando a saúde para mais perto da família e, com isso, melhorar a qualidade de vida dos brasileiros. Trata-se: ");
            a.setText("Programa de Saúde da Família (PSF) ");
            b.setText("Sistema Único de Saúde (SUS) ");
            c.setText("Fundo Nacional de Saúde (FNS) ");
            d.setText("Instituto Nacional do Câncer ");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 182) {
            questaoTextView.setText("São princípios básicos do SUS, exceto: ");
            a.setText("Participação da comunidade ");
            b.setText("Integralidade ");
            c.setText("Centralização ");
            d.setText("Universalização ");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 183) {
            questaoTextView.setText("Assinale a alternativa que indica o número máximo de pessoas que uma equipe de saúde de família pode ser responsável: ");
            a.setText("2500 ");
            b.setText("1500 ");
            c.setText("3500 ");
            d.setText("4500 ");
            e.setText("5000");
            alt = R.id.d;
        }
        if (question == 184) {
            questaoTextView.setText("Assinale a alternativa correta sobre o número mínimo de membros de uma equipe do PSF: ");
            a.setText("1 médico, 1 enfermeiro, 1 auxiliar de enfermagem, 6 a 8 agentes comunitários de saúde. ");
            b.setText("1 médico, 1 enfermeiro, 2 auxiliar de enfermagem, 4 a 6 agentes comunitários de saúde. ");
            c.setText("1 médico, 2 enfermeiro, 2 auxiliar de enfermagem, 6 a 8 agentes comunitários de saúde. ");
            d.setText("1 médico, 1 enfermeiro, 1 auxiliar de enfermagem, 4 a 6 agentes comunitários de saúde. ");
            e.setText("2 médico, 1 enfermeiro, 1 auxiliar de enfermagem, 4 a 6 agentes comunitários de saúde. ");
            alt = R.id.d;
        }
        if (question == 185) {
            questaoTextView.setText("Qual é a capacidade de resolução de uma unidade básica do PSF quando funcionando adequadamente? ");
            a.setText("55% ");
            b.setText("35% ");
            c.setText("85% ");
            d.setText("15% ");
            e.setText("17% ");
            alt = R.id.c;
        }
        if (question == 186) {
            questaoTextView.setText("Atende a todos os integrantes de cada família, independente de sexo e idade, desenvolve com os demais integrantes da equipe, ações preventivas e de promoção da qualidade de vida da população. Essas são as atribuições de qual membro da equipe do PSF? ");
            a.setText("Enfermeiro ");
            b.setText("Médico ");
            c.setText("Auxiliar de enfermagem ");
            d.setText("Agente comunitário de saúde (ACS) ");
            e.setText("Agente de saúde");
            alt = R.id.b;
        }
        if (question == 187) {
            questaoTextView.setText("Faz a ligação entre as famílias e o serviço de saúde, visitando cada domicílio pelo menos uma vez por mês, realiza o mapeamento de cada área, o cadastramento das famílias e estimula a comunidade para práticas que proporcionem melhores condições de saúde e de vida. Essas são as atribuições de qual membro da equipe do PSF? ");
            a.setText("Enfermeiro ");
            b.setText("ACS ");
            c.setText("Auxiliar de enfermagem ");
            d.setText("Médico ");
            e.setText("Médico Veterinário");
            alt = R.id.b;
        }
        if (question == 188) {
            questaoTextView.setText("Processo particular de expressão das condições de vida de uma sociedade, representando as diferentes qualidades do processo vital e as diferentes competências para enfrentar desafios, agressões, conflitos, mudança. Tem uma dupla e contraditória natureza: biológica e psicológica. Tratase de: ");
            a.setText("Processo saúde-doença. ");
            b.setText("Processo transmissão. ");
            c.setText("Processo diagnóstico. ");
            d.setText("Processo terapêutico. ");
            e.setText("Processo terapêutico e diagnóstico. ");
            alt = R.id.a;
        }
        if (question == 189) {
            questaoTextView.setText("A direção do SUS é exercida no âmbito da União pelo(a): ");
            a.setText("Secretaria de Saúde ");
            b.setText("Congresso Federal ");
            c.setText("Ministério da Saúde ");
            d.setText("Presidente da República ");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 190) {
            questaoTextView.setText("Tem por finalidade propor prioridades, métodos e estratégias para a formação e educação continuada dos recursos humanos do SUS, assim como em relação à pesquisa e à cooperação técnica entre essas instituições (ensino profissional e superior). Trata-se de(a): ");
            a.setText("Comissões permanentes de integração entre serviços de saúde e instituições de ensino. ");
            b.setText("Comissões intersetoriais de integração entre serviços de saúde e instituições de ensino. ");
            c.setText("Comissões interestaduais de integração entre serviços de saúde e instituições de ensino. ");
            d.setText("Comissões intermunicipais de integração entre serviços de saúde e instituições de ensino. ");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 191) {
            questaoTextView.setText("São atribuições da União, dos Estados, do Distrito Federal e dos municípios, exceto: ");
            a.setText("Implementar o Sistema Nacional de sangue, componentes e derivados. ");
            b.setText("Realizar pesquisas e estudos na área de saúde. ");
            c.setText("Elaboração e atualização periódica dos planos de saúde. ");
            d.setText("Controlar e fiscalizar os procedimentos dos serviços privados de saúde. ");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 192) {
            questaoTextView.setText("À direção nacional do SUS compete, exceto: ");
            a.setText("Formular, avaliar e apoiar políticas de alimentação e nutrição. ");
            b.setText("Formar consórcios administrativos intermunicipais. ");
            c.setText("Coordenar e participar na execução da vigilância epidemiológica ");
            d.setText("Controlar e fiscalizar procedimentos, produtos e substâncias de interesse para a saúde. ");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 193) {
            questaoTextView.setText("São etapas da implantação do PSF, exceto: ");
            a.setText("Solicitar formalmente ao Ministério da Saúde a adesão do município ao PSF. ");
            b.setText("Selecionar, contratar e capacitar os profissionais que atuarão no programa. ");
            c.setText("dentificar as áreas prioritárias para a implantação do programa; mapear o número de habitantes em cada área. ");
            d.setText("Calcular o número de equipes e de agentes comunitários necessários. ");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 194) {
            questaoTextView.setText("Assinale a alternativa incorreta: ");
            a.setText("A assistência à saúde é livre à iniciativa privada. ");
            b.setText("É autorizada a participação direta ou indiretamente de empresas ou de capitais estrangeiros na assistência à saúde. ");
            c.setText("Os critérios e valores para a remuneração de serviços e os parâmetros de cobertura assistencial serão estabelecidos pela direção nacional do SUS, aprovados no Conselho Nacional de Saúde. ");
            d.setText("Quando as suas disponibilidades forem insuficientes para garantir a cobertura assistencial à população de uma determinada área, o SUS poderá recorrer aos serviços ofertados pela iniciativa privada. ");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 195) {
            questaoTextView.setText("Serão co-financiadas pelo SUS, pelas universidades e pelo orçamento fiscal, além de recursos de instituição de fomento e financiamento ou de origem externa e receita própria das instituições executoras. Trata-se: ");
            a.setText("Atividades de pesquisa e desenvolvimento científico e tecnológico em saúde. ");
            b.setText("Ações de saneamento. ");
            c.setText("Recuperação de viciados. ");
            d.setText("Ações de vacinação. ");
            e.setText("Ações contra o câncer");
            alt = R.id.a;
        }
        if (question == 196) {
            questaoTextView.setText("Assinale a alternativa que indica corretamente qual foi a primeira modalidade de seguro para trabalhadores do setor privado: ");
            a.setText("SUS (Sistema Único de Saúde). ");
            b.setText("IAP (Institutos de Aposentadorias e Pensões). ");
            c.setText("INPS (Instituto Nacional de Previdência Social). ");
            d.setText("CAP (Caixas de Aposentadorias e Pensões). ");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 197) {
            questaoTextView.setText("São características até hoje do sistema previdenciário, exceto: ");
            a.setText("Instituição, por iniciativa do Estado, da implementação de um seguro social com caráter altamente controlador dos segmentos de trabalhadores dos setores essenciais à economia brasileira. ");
            b.setText("A forma tripartite de financiamento – empregadores, trabalhadores e Estado – este último arrecadando recursos para tal fim a partir da criação de novos impostos. ");
            c.setText("O acesso do trabalhador e seus dependentes à assistência médica na condição de filiado ao segurosocial. ");
            d.setText("O caráter assistencialista e universalizante do seguro social. ");
            e.setText("N.D.A");
            alt = R.id.d;
        }
        if (question == 198) {
            questaoTextView.setText("A contribuição dos empregados, que era um porcentual sobre o faturamento da empresa, passa a ser um percentual sobre a sua folha de salários, com o que a receita das instituições torna-se função dos salários. Essa alteração ocorreu: ");
            a.setText("Do INPS para o SUS. ");
            b.setText("Do IAP para o INPS. ");
            c.setText("Do CAP para o IAP. ");
            d.setText("Do INPS para o CAP. ");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 199) {
            questaoTextView.setText("Não se trata de uma característica do atual perfil de organização de serviços de saúde no país: ");
            a.setText("Com acentuadas distorções na sua forma de financiamento. ");
            b.setText("Acentuadamente estatizado. ");
            c.setText("Altamente centralizado. ");
            d.setText("Com clara divisão de trabalho entre os setores público e privado. ");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 200) {
            questaoTextView.setText("Assinale a alternativa que indica o tipo de país que mais gasta em saúde per capita: ");
            a.setText("América Latina. ");
            b.setText("Países em transição demográfica. ");
            c.setText("Países com economia de mercado consolidada. ");
            d.setText("Sudeste asiático. ");
            e.setText("Bolívia");
            alt = R.id.c;
        }
        if (question == 201) {
            questaoTextView.setText("Em relação à organização do SUS é incorreto afirmar: ");
            a.setText("O detalhamento das diretrizes e das modalidades operacionais previstas para esse sistema foram regulamentadas pelas leis 8080 de 1990 e 8142 de 1991 conhecidas como Lei Orgânica da Saúde (LOS). ");
            b.setText("Pode-se dividir as esferas de atendimento como terciária, secundária e primária correspondendo à esfera terciária os chamados centros de saúde (a saúde em nível de distritos). ");
            c.setText("Possui como objetivo a universalização da assistência, ou seja, busca o combate à pobreza e principalmente a exclusão social. ");
            d.setText("Está organizado ao nível das três esferas governamentais como serviço público de saúde (federal, estadual e municipal) competindo a cada esfera sua organização ao seu nível, ou seja, à esfera federal compete a formulação de políticas nacionais, à estadual, políticas estaduais de saúde e à municipal, políticas municipais de saúde. ");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 202) {
            questaoTextView.setText("Em relação à articulação entre o setor público de saúde e o setor privado de saúde pode-se afirmar que: ");
            a.setText("Dentre os dois segmentos do setor privado, o lucrativo e o não-lucrativo, o setor lucrativo é o que mais se articula ao SUS por meio de contratos para a prestação de serviços. ");
            b.setText("Não há qualquer tipo de articulação entre estes sistemas, uma vez que funcionam de maneira completamente independente. ");
            c.setText("O segmento não-lucrativo do setor privado abrange instituições filantrópicas, tais como as Santas Casas de Misericórdia, sendo que boa parte delas vinculam-se ao SUS por meio de contratos para prestação de serviços. ");
            d.setText("O segmento lucrativo tem como sua parcela mais expressiva o chamado sistema supletivo de assistência médica abarcando apenas as cooperativas médicas e os planos de administração. ");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 203) {
            questaoTextView.setText("Os estabelecimentos assistenciais que compõem a rede de serviços de saúde – estatais e privados – são usualmente classificados em postos de saúde, centros de saúde, unidades mistas, policlínicas, pronto-socorros e hospitais. Assinale a alternativa que melhor correlaciona o estabelecimento e sua função: ");
            a.setText("Centro de saúde: presta assistência à saúde de determinada população valendo-se de procedimentos mais simplificados, praticamente sem incorporações de equipamentos. ");
            b.setText("Policlínica: tipo de serviço que apresenta atendimento ambulatorial especializado concentrando-se nas cidades de médio e grande porte e nas regiões economicamente mais desenvolvidas, atua no nível da atenção secundária na modalidade ambulatorial. ");
            c.setText("Pronto-socorro: estabelecimento voltado para a assistência médica em regime de internação. ");
            d.setText("Hospital: estabelecimento com pequena incorporação de tecnologias, atua no nível primário de atenção. ");
            e.setText("N.D.A");
            alt = R.id.b;
        }
        if (question == 204) {
            questaoTextView.setText("Assinale a alternativa incorreta a respeito do PSF: ");
            a.setText("A estratégia do PSF foi iniciada em junho de 1991, com a implantação do Programa de Agentes Comunitários de Saúde (PACS). ");
            b.setText("Em janeiro de 1994, foram formadas as primeiras equipes de Saúde da Família. ");
            c.setText("A proporção média é de um Agente Comunitário de Saúde para 1000 pessoas acompanhadas. ");
            d.setText("Deve prestar atendimento de bom nível, prevenindo doenças, evitando internações desnecessárias e melhorando a qualidade de vida da população. ");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 205) {
            questaoTextView.setText("Assinale a alternativa correta a respeito da lei 8142: ");
            a.setText("Dispõe sobre a participação direção  na gestão do SUS e sobre as transferências intergovernamentais de recursos financeiros na área da saúde. ");
            b.setText("Dispõe sobre as condições para a promoção, proteção e recuperação da saúde, a organização e o funcionamento dos serviços correspondentes. ");
            c.setText("Dispõe sobre licitação e contratos da Administração. ");
            d.setText("Da nova redação ao artigo 177 da Constituição Federal, alterando e inserindo parágrafos. ");
            e.setText("Dispõe sobre a participação da comunidade na gestão do SUS e sobre as transferências intergovernamentais de recursos financeiros na área da saúde.");
            alt = R.id.e;
        }
        if (question == 206) {
            questaoTextView.setText("Reunir-se-á a cada quatro anos com a representação de vários segmentos sociais, para avaliar a situação de saúde e propor as diretrizes para a formulação da política de saúde nos níveis correspondentes, convocada pelo Poder Executivo ou, extraordinariamente, por esta ou pelo Conselho de Saúde. Trata-se:");
            a.setText("Conselho Nacional de Secretários de Saúde. ");
            b.setText("Conselho de Saúde.");
            c.setText("Ministério da Saúde.");
            d.setText("Ministro da Saúde.");
            e.setText("Conferencia de Saúde.");
            alt = R.id.e;
        }
        if (question == 207) {
            questaoTextView.setText("Consiste na complementação da renda familiar, com recursos da União, para melhoria da alimentação e das condições de saúde e nutrição. Trata-se do programa de saúde:");
            a.setText("Brasil Sorridente.");
            b.setText("Cartão Nacional de Saúde.");
            c.setText("Política Nacional de Alimentação e Nutrição.");
            d.setText("Bolsa Alimentação.");
            e.setText("Bolsa estudo.");
            alt = R.id.d;
        }
        if (question == 208) {
            questaoTextView.setText("O objetivo é facilitar o atendimento, possibilitando uma identificação mais rápida do paciente, a marcação de consultas e exames e melhorar o acesso aos medicamentos pela rede do SUS. Trata-se do programa:");
            a.setText("HumanizaSUS.");
            b.setText("Sistema de Informação da Atenção Básica.");
            c.setText("Banco de preços em Saúde-AIDS.");
            d.setText("Banco de preços em Saúde-HPV.");
            e.setText("Cartão Nacional de Saúde.");
            alt = R.id.e;
        }
        if (question == 209) {
            questaoTextView.setText("Tem a função de monitorar os indicadores de saúde das populações, a partir de informações dos agentes e das equipes de Saúde da Família. Trata-se do programa:");
            a.setText("Sistema de Informação da Atenção Básica.");
            b.setText("Programa Saúde da Família.");
            c.setText("Cartão Nacional de Saúde.");
            d.setText("Projeto Expande.");
            e.setText("Projeto Estudo.");
            alt = R.id.a;
        }
        if (question == 210) {
            questaoTextView.setText("Lançado em 2001 e desenvolvido juntamente com as Secretarias de Assistência à Saúde e Secretaria Executiva, ambos do Ministério da Saúde. Tem como principal objetivo estruturar a integração da assistência oncológica no Brasil a fim de obter um padrão de alta qualidade na cobertura da população. Trata-se do programa:");
            a.setText("Programa Saúde da Família.");
            b.setText("ReforSUS.");
            c.setText("Projeto Expande");
            d.setText("Programa Nacional de Controle do Câncer do Colo do Útero e de Mama – Viva Mulher.");
            e.setText("N.D.A");
            alt = R.id.c;
        }
        if (question == 211) {
            questaoTextView.setText("Em relação à participação da comunidade no SUS, pode-se afirmar que a legislação vigente:");
            a.setText("Prevê a participação somente dos usuários do SUS.");
            b.setText("Prevê somente a participação dos usuários do SUS e dos representantes dos poderes públicos.");
            c.setText("Não contempla a representação dos profissionais de saúde.");
            d.setText("Determina que os Conselhos de Saúde constituam a instância de participação da comunidade.");
            e.setText("Não contempla a representação dos médicos. ");
            alt = R.id.d;
        }
        if (question == 212) {
            questaoTextView.setText("Qual é a porcentagem, aproximada, da participação da esfera federal nos gastos públicos em saúde?");
            a.setText("10 a 20% ");
            b.setText("30 a 40% ");
            c.setText("50 a 60% ");
            d.setText("70 a 80% ");
            e.setText("70 a 90% ");
            alt = R.id.d;
        }
        if (question == 213) {
            questaoTextView.setText("egundo a Lei nº 8080/90, que regulamenta o Sistema Único de Saúde (SUS), a participação da iniciativa privada na assistência à saúde é: ");
            a.setText("livre ");
            b.setText("obrigatória ");
            c.setText("minoritária ");
            d.setText("prioritária ");
            e.setText("proibida ");
            alt = R.id.a;
        }
        if (question == 214) {
            questaoTextView.setText("É uma instância colegiada do Sistema Único de Saúde: ");
            a.setText("Ministério da Saúde; ");
            b.setText("Fundo Municipal de Saúde; ");
            c.setText("Conferência de Saúde; ");
            d.setText("Secretaria de Assistência à Saúde; ");
            e.setText("Secretaria de Vigilância à Saúde. ");
            alt = R.id.c;
        }
        if (question == 215) {
            questaoTextView.setText("Segundo a Lei nº 8142/90, que dispõe sobre a participação da comunidade na gestão do Sistema Único de Saúde (SUS), a Conferência de Saúde deve reunir-se a cada ");
            a.setText("ano ");
            b.setText("dois anos ");
            c.setText("três anos ");
            d.setText("quatro anos ");
            e.setText("cinco anos ");
            alt = R.id.d;
        }
        if (question == 216) {
            questaoTextView.setText("A realização das funções de controle e avaliação em saúde devem ser feitas: ");
            a.setText("pela Presidência da República ");
            b.setText("por todos os níveis do sistema de saúde ");
            c.setText("por todos os níveis do sistema de saúde ");
            d.setText("pelos governos estaduais ");
            e.setText("pelos conselhos comunitários ");
            alt = R.id.b;
        }
        if (question == 217) {
            questaoTextView.setText("Segundo a Norma Operacional da Assistência à Saúde – NOAS 01/2002 –, os municípios poderão habilitar-se à gestão do sistema de saúde de forma: ");
            a.setText("semiplena ");
            b.setText("plena somente em relação à atenção básica ampliada ");
            c.setText("semiplena somente em relação à atenção básica ampliada ");
            d.setText("semiplena somente em relação à atenção terciária. ");
            e.setText("plena ");
            alt = R.id.e;
        }
        if (question == 218) {
            questaoTextView.setText("Segundo a Lei nº 8080/90, constitui um critério para o estabelecimento de valores a serem transferidos a estados, Distrito Federal e municípios: ");
            a.setText("participação paritária dos usuários no conselho de saúde ");
            b.setText("prioridade para o atendimento hospitalar ");
            c.setText("desempenho técnico, econômico e financeiro no período atual ");
            d.setText("eficiência na arrecadação de impostos ");
            e.setText("perfil epidemiológico da população a ser coberta ");
            alt = R.id.e;
        }
        if (question == 219) {
            questaoTextView.setText("As ações e serviços públicos de saúde integram uma rede regionalizada e hierarquizada e constituem um sistema único que visa: ");
            a.setText("o atendimento voltado para atividades preventivas; ");
            b.setText("o atendimento integral, com prioridade para as atividades preventivas, sem prejuízo dos serviços assistenciais; ");
            c.setText("apenas ações de promoção da saúde; ");
            d.setText("apenas ações de prevenção secundária; ");
            e.setText("o atendimento voltado apenas para as atividades assistenciais. ");
            alt = R.id.b;
        }
        if (question == 220) {
            questaoTextView.setText("NÃO se inclui entre os objetivos do Sistema Único de Saúde: ");
            a.setText("identificação dos fatores determinantes da saúde; ");
            b.setText("formulação de política de saúde destinada a promover, nos campos econômico e social, a redução de riscos de doenças e de outros agravos; ");
            c.setText("assistência às pessoas por intermédio de ações de promoção, proteção e recuperação da saúde, com a realização integrada das ações assistenciais e das atividades preventivas; ");
            d.setText("divulgação dos fatores determinantes da saúde; ");
            e.setText("participação prioritária da iniciativa privada na assistência à saúde. ");
            alt = R.id.e;
        }
        if (question == 221) {
            questaoTextView.setText("Assinale a alternativa que apresenta um dos temas abordados na 8ª Conferência Nacional de Saúde e que foi um dos alicerces na criação do SUS. ");
            a.setText("Organização Sanitária estadual ");
            b.setText("Saúde como direito ");
            c.setText("Municipalização dos serviços ");
            d.setText("Politica nacional de saúde ");
            e.setText("Interiorização das ações ");
            alt = R.id.b;
        }
        if (question == 222) {
            questaoTextView.setText("Assinale a seguir a ação que NÃO está incluída no campo de atuação do Sistema Único de Saúde (SUS) ");
            a.setText("Vigilância sanitária. ");
            b.setText("Saúde do trabalhador. ");
            c.setText("Vigilância epidemiológica. ");
            d.setText("Assistência social. ");
            e.setText("Assistência terapêutica integral, inclusive farmacêutica. ");
            alt = R.id.d;
        }
        if (question == 223) {
            questaoTextView.setText("Qual dos itens a seguir NÃO faz parte do Sistema de Informação em Saúde de Base Nacional? ");
            a.setText("SINASC – Sistema de Informação sobre Nascidos Vivos. ");
            b.setText("SISVA – Sistema de Vigilância Ambiental. ");
            c.setText("SIAB – Sistema de Informação da Atenção Básica. ");
            d.setText("SINAN – Sistema de Informação de Agravos de Notificação. ");
            e.setText("SIS EAPV – Sistema de Informação sobre Eventos Adversos Pós-vacinais. ");
            alt = R.id.b;
        }
        if (question == 224) {
            questaoTextView.setText("O que é o Conselho de Saúde? ");
            a.setText("É o órgão colegiado, deliberativo e permanente do Sistema Único de Saúde (SUS) em cada esfera de governo. ");
            b.setText("É o conselho que determina a seleção e a padronização de medicamentos indicados para atendimento de doenças ou de agravos no âmbito do SUS. ");
            c.setText("O conselho de saúde determina o conjunto de ações e serviços de saúde, prestados por órgãos e instituições públicas federais, estaduais e municipais. ");
            d.setText("O conselho de saúde viabiliza as ações e serviços de saúde voltados para o atendimento das populações indígenas, em todo o território nacional, coletiva ou individualmente. ");
            e.setText("É o conjunto de sistemas nacionais de informação de interesse para a saúde, gerenciado por órgãos do Governo Federal. ");
            alt = R.id.a;
        }
        if (question == 225) {
            questaoTextView.setText("O acesso aos relatórios do Sistema de Informação sobre Mortalidade é importante para a o Sistema Nacional de Vigilância Epidemiológica porque ");
            a.setText("contém informações sobre as características de pessoa, tempo e lugar, condições de óbito, assistência prestada ao paciente, causas básicas e associadas. ");
            b.setText("permite que esses relatórios sejam distribuídos nacionalmente pelo Ministério da Saúde. ");
            c.setText("servem como fonte de dados para conhecimento da situação de saúde. O SIM contribui para obter informação sobre a mortalidade infantil. ");
            d.setText("permite o registro e o processamento dos dados sobre mortalidade em todo o território nacional, fornecendo informações para a análise do perfil de morbidade e contribuindo, dessa forma, para a tomada de decisões em níveis municipal, estadual e federal. ");
            e.setText("permite realizar o acompanhamento e a avaliação da cobertura vacinal e a relação com a mortalidade, tanto no município como no Estado e no País. ");
            alt = R.id.a;
        }
        if (question == 226) {
            questaoTextView.setText("Assinale a alternativa que NÃO está relacionada ao acesso universal e igualitário à assistência farmacêutica. ");
            a.setText("Estar o usuário assistido por ações e serviços de saúde do SUS. ");
            b.setText("Ter o medicamento sido prescrito por profissional de saúde no exercício regular de suas funções no SUS. ");
            c.setText("Estar a prescrição em conformidade com a RENAME e os Protocolos Clínicos e Diretrizes Terapêuticas ou com a relação específica complementar estadual, distrital ou municipal de medicamentos. ");
            d.setText("Ter a dispensação ocorrido em unidades indicadas pela direção do SUS. ");
            e.setText("Ter o ressarcimento das despesas com o atendimento e com medicamentos utilizados por profissional de saúde na rede privada ");
            alt = R.id.e;
        }
        if (question == 227) {
            questaoTextView.setText("A Constituição Federal de 1988, no Título II, Capítulo II, seção II que trata da saúde, destaca como competência do Sistema Único de Saúde (SUS): ");
            a.setText("A execução das ações de vigilância sanitária e epidemiológica, bem como as de saúde do trabalhador. ");
            b.setText("O destino de recursos para as universidades públicas ou privadas que formam os profissionais da área da saúde. ");
            c.setText("O ordenamento da formação de recursos humanos na área de saúde através do financiamento dos cursos superiores de saúde. ");
            d.setText("Colaborar na proteção do meio ambiente, nele compreendida a limpeza e manutenção de córregos e rios, bem como a fiscalização dos mananciais. ");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 228) {
            questaoTextView.setText("Referem-se às instâncias colegiadas municipais do Sistema Único de Saúde previstas na Lei Federal 8.142/90 do Ministério da Saúde: ");
            a.setText("Câmara Técnica de Saúde e Diretoria Colegiada da Saúde. ");
            b.setText("Diretoria Colegiada da Saúde e Diretoria Técnica da Saúde. ");
            c.setText("Conferência Municipal de Saúde e Diretoria Colegiada da Saúde. ");
            d.setText("Conferência Municipal de Saúde e Conselho Municipal de Saúde. ");
            e.setText("Conferência Municipal de Saúde e Conselho Estadual de Saúde. ");
            alt = R.id.d;
        }
        if (question == 229) {
            questaoTextView.setText("No Sistema Único de Saúde, a Política Nacional de Humanização utiliza como princípios norteadores: ");
            a.setText("O fortalecimento da participação popular em todas as instâncias gestoras do SUS. ");
            b.setText("O acolhimento dos usuários de forma resolutiva e respeitosa através da organização de filas que promovam a otimização dos serviços. ");
            c.setText("O fortalecimento dos direitos do cidadão, considerando a hora de chegada na unidade de saúde ou o número de ordem na fila de espera para definir as prioridades de atendimento. ");
            d.setText("O fortalecimento dos direitos do cidadão, considerando a hora de chegada na unidade de saúde ou o número de ordem na fila de espera para definir as prioridades de atendimento. ");
            e.setText("N.D.A");
            alt = R.id.a;
        }
        if (question == 230) {
            questaoTextView.setText("Em relação às diretrizes e à organização do SUS, assinale a alternativa correta. ");
            a.setText("A saúde é direito de todos e dever do Estado, garantido mediante políticas sociais e econômicas que visem à redução do risco de doença e de outros agravos. ");
            b.setText("As ações e serviços públicos de saúde integram uma rede globalizada e hierarquizada. ");
            c.setText("O SUS será financiado exclusivamente com recursos do orçamento da seguridade social. ");
            d.setText("A assistência à saúde não é livre à iniciativa privada. ");
            e.setText("É permitida a destinação de recursos públicos para auxílios ou subvenções às instituições privadas com fins lucrativos. ");
            alt = R.id.a;
        }
        if (question == 231) {
            questaoTextView.setText("No tocante à competência do SUS, conforme a Constituição Federal, assinale a alternativa correta. ");
            a.setText("Ao SUS, não compete executar as ações de vigilância sanitária e epidemiológica, bem como as de saúde do trabalhador. ");
            b.setText("Cabe ao SUS controlar e fiscalizar procedimentos, produtos e substâncias de interesse para a saúde. ");
            c.setText("Não compete ao SUS participar da formulação da política e da execução das ações de saneamento básico. ");
            d.setText("O SUS é incompetente para incrementar, em sua área de atuação, o desenvolvimento científico e tecnológico e a inovação. ");
            e.setText("Compete ao SUS colaborar na proteção do meio ambiente, não sendo nele compreendido o do trabalho ");
            alt = R.id.b;
        }
        if (question == 232) {
            questaoTextView.setText("Sistema que disponibiliza informações para subsidiar a tomada de decisão, a gestão e a geração de conhecimento. Demonstrando a atuação governamental no âmbito do SUS, possibilita também projeções e inferências setoriais, além de contribuir para a transparência das ações desenvolvidas na área de saúde. Esse sistema é chamado de : ");
            a.setText("SISAUD ");
            b.setText("E-SUS AB ");
            c.setText("SISPART ");
            d.setText("Sala de Apoio a Gestão Estratégica do SUS – SAGE ");
            e.setText("SIVEP ");
            alt = R.id.d;
        }
        if (question == 233) {
            questaoTextView.setText("A ideia de participação da comunidade no SUS se relaciona a um processo mais abrangente de ampliação da participação direta da sociedade nos processos políticos do país. Para operacionalizar a participação social na saúde, a Lei Orgânica da Saúde, Lei Federal nº 8.142/90 propôs a conformação de conselhos de saúde nas três esferas de governo: União, Estados e Municípios. Quais os segmentos sociais conforme a Lei citada, participam desses conselhos: ");
            a.setText("Governo, prestadores de serviços, profissionais de saúde e usuários. ");
            b.setText("Profissionais de saúde, líderes comunitários, vereadores e Prefeitos. ");
            c.setText("Governo, hospitais, usuários e líderes comunitários. ");
            d.setText("Prestadores de serviços, secretário, pastoral e igreja. ");
            e.setText("Profissionais liberais, controle social, usuários e governo. ");
            alt = R.id.a;
        }
        if (question == 234) {
            questaoTextView.setText("A trajetória das conquistas populares no Brasil tem sido importante para a mobilização social em defesa do direito à saúde. A década de 1980 foi marcada por representar o momento de institucionalização das práticas inovadoras para o setor de saúde, por terem sido estas fundamentadas na concepção da saúde como produto social e direito, e que foram consolidadas na década de 1990, nas conferências e nos conselhos de saúde. Em que momento frente às conferências, foi fundamental para dar embate ao processo de consolidação do SUS: ");
            a.setText("Na 8ª Conferência de Saúde de 1991. ");
            b.setText("Na 8ª Conferência de Saúde de 1990. ");
            c.setText("Na 8ª Conferência de Saúde de 1986. ");
            d.setText("Na 12ª Conferência de Saúde de 1986. ");
            e.setText("Na 12ª Conferência de Saúde de 1986. ");
            alt = R.id.c;
        }
        if (question == 235) {
            questaoTextView.setText("O Pacto pela Saúde de 2006, compreende um conjunto de compromissos estabelecidos entre os gestores da saúde nas três esferas de governo, com o objetivo de fortalecimento do SUS. A proposta do Pacto foi construída durante três anos, por meio de muita negociação entre os representantes do Ministério da Saúde. O documento do Pacto apresenta uma série de orientações e estratégias organizadas para direcionamento das ações em saúde. Como fica dividido esses eixos para o desenvolvimento das ações de saúde pelos municípios, no cenário brasileiro: ");
            a.setText("Pacto em defesa do SUS, Regionalização do SUS e Gestão. ");
            b.setText("Pacto pela vida, Pacto em defesa do SUS e Pacto de Gestão. ");
            c.setText("Pacto pela vida, Processo de descentralização do SUS e Gestão. ");
            d.setText("Pacto pela vida, Colegiado de Gestão e Descentralização. ");
            e.setText("Pacto em defesa do SUS, Controle Social e Regionalização. ");
            alt = R.id.b;
        }
        if (question == 236) {
            questaoTextView.setText("Na Constituição Federal de 1988 consolida o marco legal do SUS como um sistema de direito universal, descentralizado e participativo. Em qual artigo da Constituição Federal, diz que a saúde é direito de todos e dever do Estado, garantido mediante políticas sociais e econômicas que visem à redução do risco de doença e de outros agravos a ao acesso universal e igualitário às ações e serviços para a sua  promoção, proteção e recuperação da saúde. ");
            a.setText("Artigo 196 da Constituição Federal de 1990. ");
            b.setText("Artigo 197 da Constituição Federal de 1988. ");
            c.setText("Artigo 198 da Constituição Federal de 1988. ");
            d.setText("Artigo 196 da Constituição Federal de 1988. ");
            e.setText("Artigo 197 da Constituição Federal de 1990. ");
            alt = R.id.d;
        }
        if (question == 237) {
            questaoTextView.setText("Conforme determinado pela Constituição do Brasil de 1988, a assistência à saúde é ");
            a.setText("proibida à iniciativa privada. ");
            b.setText("livre à iniciativa privada. ");
            c.setText("permitida à iniciativa privada apenas para transplantes. ");
            d.setText("permitida à iniciativa privada apenas para  oncologiaa. ");
            e.setText("permitida à iniciativa privada apenas para atendimento a urgências. ");
            alt = R.id.b;
        }
        if (question == 238) {
            questaoTextView.setText("Segundo a Lei n. 8.080/90, na esfera federal, os recursos financeiros originários do orçamento da Seguridade Social, de outros orçamentos da União, além de outras fontes serão administrados pelo Ministério da Saúde, por meio do ");
            a.setText("Fundo do Tribunal de Contas da União. ");
            b.setText("Fundo Municipal de Saúde. ");
            c.setText("Fundo Estadual de Saúde. ");
            d.setText("Fundo Nacional de Saúde. ");
            e.setText("Fundo Nacional da Economia. ");
            alt = R.id.d;
        }
        if (question == 239) {
            questaoTextView.setText("A Constituição Federal estabelece que o Sistema Único de Saúde deve ser organizado de acordo com as diretrizes de descentralização, atendimento integral e participação da comunidade. Com relação a essas diretrizes, é correto afirmar que ");
            a.setText("a descentralização significa que a gestão do sistema de saúde passa a ser executada pelas unidades da federação. ");
            b.setText("a descentralização implica que o município formule suas próprias políticas de saúde e atue como parceiro para a aplicação de políticas nacionais e estaduais de saúde. ");
            c.setText("o atendimento integral pressupõe que cada município deva ofertar na integralidade os serviços de saúde, por meio de recursos próprios. ");
            d.setText("a participação da comunidade sobre a aplicação dos recursos da saúde se dá por meio dos Tribunais de Conta Municipais. ");
            e.setText("a participação e o controle social são feitos pelos conselhos de saúde, com participação em igual número de representantes dos usuários, dos trabalhadores da saúde e dos prestadores de serviço. ");
            alt = R.id.b;
        }
        return alt;
    }
}
