package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Autor;
import guru.springframework.spring5webapp.model.Buch;
import guru.springframework.spring5webapp.model.Verlag;
import guru.springframework.spring5webapp.repositories.AutorRepository;
import guru.springframework.spring5webapp.repositories.BuchRepository;
import guru.springframework.spring5webapp.repositories.VerlagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AutorRepository autorRepository;
    private final BuchRepository buchRepository;
    private final VerlagRepository verlagRepository;

    public BootstrapData(AutorRepository autorRepository, BuchRepository buchRepository, VerlagRepository verlagRepository) {
        this.autorRepository = autorRepository;
        this.buchRepository = buchRepository;
        this.verlagRepository = verlagRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Autor maxMustermann = new Autor("Max", "Mustermann");
        Buch harryPotter = new Buch("Softwareentwicklung", "1234");
        Verlag beckerVerlag=new Verlag("Beckerverlag","Hauptstrasse 11","49074","Osnabrueck");

        verlagRepository.save(beckerVerlag);

        maxMustermann.getBuecher().add(harryPotter);
        harryPotter.getAutoren().add(maxMustermann);
        harryPotter.setVerlag(beckerVerlag);
        beckerVerlag.getBuecher().add(harryPotter);

        autorRepository.save(maxMustermann);
        buchRepository.save(harryPotter);
        verlagRepository.save(beckerVerlag);

        Autor bertaBeispiel = new Autor("Berta", "Beispiel");
        Buch theStand = new Buch("The Stand", "45678");

        bertaBeispiel.getBuecher().add(theStand);
        theStand.getAutoren().add(bertaBeispiel);
        theStand.setVerlag(beckerVerlag);
        beckerVerlag.getBuecher().add(theStand);

        autorRepository.save(bertaBeispiel);
        buchRepository.save(theStand);
        verlagRepository.save(beckerVerlag);

        System.out.println("Gestartet in Klasse BootstrapData");
        System.out.println("Anzahl Buecher: " + buchRepository.count());
        System.out.println("Anzahl Autoren: " + autorRepository.count());
        System.out.println("Anzahl Verlage: "+ verlagRepository.count());

        System.out.println("Anzahl Buecher in Becker-Verlag: "+beckerVerlag.getBuecher().size());

//        for(Verlag einVerlag:verlagRepository.findAll())
//        {
//            System.out.println(einVerlag.getName()+" hat "+ einVerlag.getBuecher().size()+ "Buecher: "); //bei einVerlag.getBuecher() erscheint LazyInitializationException
//            System.out.println("----------------------------");
//            for(Buch einBuchdesVerlags: einVerlag.getBuecher())
//            {
//                System.out.println(einBuchdesVerlags);
//            }
//        }
    }
}
