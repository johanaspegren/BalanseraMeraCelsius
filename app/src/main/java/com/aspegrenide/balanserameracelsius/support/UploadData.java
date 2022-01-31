package com.aspegrenide.balanserameracelsius.support;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UploadData {

    // Use FireBase database to keep track of the videos
    private DatabaseReference fbDatabaseReference;

    public Exercise makeExercise1() {
        Exercise e = new Exercise("Stå med samlade ben. Håll i dig");
        e.setDescription("Håll balansen");
        e.setMakeItHarder("Genom att släppa händerna, kan även prova att blunda, eller vrida" +
                "huvudet åt sidorna och titta upp och ner");
        e.setVideoStorageReference("HallBalansen-20211112-090853.mov");
        return e;
    }

    public Exercise makeExercise2() {
        Exercise e = new Exercise("Bred tyngöverföring");
        e.setDescription("Stå med axelbredds avstånd och böj lätt i knä och höftled. " +
                "Flytta tyngden från sida till sida utan att sträcka helt i knäna. " +
                "Vid behov håll i dig i räcke.");
        e.setMakeItHarder("-");
        e.setVideoStorageReference("Tyngdoverflyttning-20211112-090952.mov");
        return e;
    }

    public Exercise makeExercise3() {
        Exercise e = new Exercise("Stå på ett ben med stöd");
        e.setDescription("Stöd handen mot räcket. Lyft det ena benet så att du" +
                " står på ett ben. Håll ryggen\n" +
                "rak och blicken framåt. Tänk på att inte höften \"faller ut\".");
        e.setMakeItHarder("Stå utan stöd av händer.\n");
        e.setVideoStorageReference("StaPaEttBen-20211112-091100.mov");
        return e;
    }

    public Exercise makeExercise4() {
        Exercise e = new Exercise("Stå på ett ben");
        e.setDescription("Spring på stället så fort du orkar i 1 minut");
        e.setMakeItHarder("-");
        e.setVideoStorageReference("StaPaEttBen-20211112-091100.mov");
        return e;
    }

    public Exercise makeExercise5() {
        Exercise e = new Exercise("Tandem stående med stöd");
        e.setDescription("Stöd en hand mot räcket. Sätt det ena benet framför det andra. Håll\n" +
                " några sekunder och gå sedan tillbaka till utgångsläget.");
        e.setMakeItHarder("Prova utan att hålla i med händerna");
        e.setVideoStorageReference("TandemStaende_Coach-20211112-091351.mov");
        return e;
    }

    public Exercise makeExercise6() {
        Exercise e = new Exercise("Baklängesgång");
        e.setDescription("Träna att gå baklänges. Till en början kan du hålla i dig i räcket.");
        e.setMakeItHarder("Gå utan att hålla i dig");
        e.setVideoStorageReference("BaklangesGang-20211112-091519.mov");
        return e;
    }

    public Exercise makeExercise7() {
        Exercise e = new Exercise("Gångträning med vändning");
        e.setDescription("Träna på att skifta riktning och vända dig om. Gå längs räcket. Försök att minska\n" +
                "antalet steg i vändningarna. Vänd dig åt båda hållen.\n");
        e.setMakeItHarder("-");
        e.setVideoStorageReference("GangMedVandning-20211112-091626-3e031e40.mov");
        return e;
    }

    public Exercise makeExercise8() {
        Exercise e = new Exercise("Gång i sidled vid räcke");
        e.setDescription("Gå i sidled fram och tillbaka vid räcket. Kryssa inte fötterna. Ansiktet och hela\n" +
                "kroppen mot räcket.\n");
        e.setMakeItHarder("-");
        e.setVideoStorageReference("GangiSidled-20211112-091737.mov");
        return e;
    }

    public Exercise makeExercise9() {
        Exercise e = new Exercise("Tandem gång framåt, med stöd");
        e.setDescription("Stöd handen mot räcket. Sätt växelvis högra och vänstra benet framför varandra.\n");
        e.setMakeItHarder("Gå som ovan men utan stöd av händerna.");
        e.setVideoStorageReference("TandemGangFramat-20211112-091853.mov");
        return e;
    }

    public Exercise makeExercise10() {
        Exercise e = new Exercise("Tappning på step");
        e.setDescription("Berör steget/stepen med varannan fot.\n");
        e.setMakeItHarder("-");
        e.setVideoStorageReference("Step-20211112-093253.mov");
        return e;
    }

    public Exercise makeExercise11() {
        Exercise e = new Exercise("Ankelböj med belastning på step");
        e.setDescription("Placera foten på en stepbox. Håll hälen i kontakt med stepboxen och för knät\n" +
                "framåt så att ankelleden böjs. Vänd tillbaka till utgångspositionen och upprepa.\n");
        e.setMakeItHarder("-");
        e.setVideoStorageReference("TappningPaStep-20211112-092757");
        return e;
    }

    public Exercise makeExercise12() {
        Exercise e = new Exercise("Armhävningar mot ett räcke");
        e.setDescription("Luta dig mot räcket. Sänk kroppen mot väggen och pressa tillbaka. Variation:\n" +
                "smalt mellan armarna, brett mellan armarna\n");
        e.setMakeItHarder("Använd bara en hand. Flytta fötterna längre ifrån.");
        e.setVideoStorageReference("ArmhavningarMotRacke-20211112-092821.mov");
        return e;
    }

    public Exercise makeExercise13() {
        Exercise e = new Exercise("Stående tåhävning med stöd");
        e.setDescription("Ta stöd med händerna räcket. Gå upp på tå på bägge fötterna, " +
                "stå i ca 5 sek. Sänk därefter ner igen. Gå upp snabbt och långsamt ner.");
        e.setMakeItHarder("Prova att hålla i dig med händerna men stå på ett ben och gör\n" +
                "samma sak. Alternativt stå utan att hålla i dig och gå upp på båda tårna");
        e.setVideoStorageReference("staendeTahavning.mov");
        return e;
    }

    public Exercise makeExercise14() {
        Exercise e = new Exercise("Knäböj");
        e.setDescription("Stå med fötterna i höftbredd. Håll ryggen rak med blicken framåt. Böj i knäna tills" +
                "låren är parallella med golvet, rumpan ska puta ut. Pressa upp och återgå till" +
                "utgångspositionen. Alternativt kan du hålla ställningen med böjda knän i några" +
                "sekunder. Se till att ha hälarna på golvet och att knäna inte skjuter längre fram än" +
                "tårna. Finns behov håll i dig i räcke.");
        e.setMakeItHarder("Utan stöd av händerna kan man första gången prova vid en bänk där du böjer" +
                " så pass mycket i knäna så att du nästan sätter dig men sedan vänder om.");
        e.setVideoStorageReference("Knabojning-20211112-093055.mov");
        return e;
    }

    public Exercise makeExercise15() {
        Exercise e = new Exercise("Stående rotation av överkroppen");
        e.setDescription("Stå med armarna hängande ner längs sidorna. Slappna av i armarna. Gör en\n" +
                "rotationsrörelse med överkroppen och låt armarna följa med i rörelsen. Även\n" +
                "huvudet ska följa med i rörelsen.");
        e.setMakeItHarder("Gör större rörelser så rörelsen startar ända från fötterna. Minska\n" +
                "avståndet mellan fötterna.\n");
        e.setVideoStorageReference("StaendeRotationOverkropp-20211112-093152.mov");
        return e;
    }

    public Exercise makeExercise16() {
        Exercise e = new Exercise("Sträck framåt");
        e.setDescription("Stå med fötterna bredvid varandra. Böj dig framåt så långt som du vågar utan att" +
                "tappa balansen. Kan prova även åt sidorna.");
        e.setMakeItHarder("-");
        e.setVideoStorageReference("SkakaHand-20211112-093628.mov");
        return e;
    }

    public Exercise makeExercise17() {
        Exercise e = new Exercise("Gå med olika steglängd");
        e.setDescription("Gå med olika steglängd och stegbredd antingen på tänkta punkter, eller om det" +
                "finns något man kan lägga ");
        e.setMakeItHarder("-");
        e.setVideoStorageReference("GaMedOlikaSteglangd-20211112-093729.mov");
        return e;
    }

    public Exercise makeExercise18() {
        Exercise e = new Exercise("Sitta och resa sig");
        e.setDescription("Sitt på en bänk. Res dig upp, använd händerna så lite som möjligt, helst inte alls");
        e.setMakeItHarder("Res dig upp till stående på ett ben");
        e.setVideoStorageReference("SittaOchResaSig-20211112-093835.mov");
        return e;
    }

    public Exercise makeExercise19() {
        Exercise e = new Exercise("Kasta ring eller boule");
        e.setDescription("Plocka själv upp klot eller ringar för att träna balansen.");
        e.setMakeItHarder("-");
        e.setVideoStorageReference("staendeTahavning.mov");
        return e;
    }



    // vid start övning 1, balans
    public Station makeStationStart_1() {
        //56.02747389188141, 12.711012183210542
        double lat = 56.02747389188141;
        double lng = 12.711012183210542;
        Exercise e = makeExercise1();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // vid start övning 2, bred överflyttning
    public Station makeStationStart_2() {
        // 56.02748223480546, 12.710964193285026
        double lat = 56.02748223480546;
        double lng = 12.710964193285026;
        Exercise e = makeExercise2();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // vid start Stå på ett ben med stöd
    public Station makeStationStart_3() {
        // 56.02749117365065, 12.71086608054842
        double lat = 56.02749117365065;
        double lng = 12.71086608054842;
        Exercise e = makeExercise3();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // vid start tandemgång
    public Station makeStationStart_4() {
        // 56.02750607172137, 12.710823422836851
        double lat = 56.02750607172137;
        double lng = 12.710823422836851;
        Exercise e = makeExercise5();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Station 2 egentligen baklängesgång
    // 56.02694224771462, 12.71027479944444
    public Station makeStation3() {
        double lat = 56.02694224771462;
        double lng = 12.71027479944444;
        Exercise e = makeExercise6();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Station 2 egentligen gångträniong med vändning
    // 56.02694262657812, 12.71022040964986
    public Station makeStation4() {
        double lat = 56.02694262657812;
        double lng = 12.71022040964986;
        Exercise e = makeExercise7();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Station 2 egentligen gångträniong med vändning
    // 56.026964600543714, 12.710412958174459
    public Station makeStation5() {
        double lat = 56.026964600543714;
        double lng = 12.710412958174459;
        Exercise e = makeExercise8();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Station 2 egentligen gångträniong med vändning
    // 56.026986574496846, 12.710260410927859
    public Station makeStation6() {
        double lat = 56.026986574496846;
        double lng = 12.710260410927859;
        Exercise e = makeExercise9();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }


    // Gymmet övning 1 step tappning
    public Station makeStationGym_1() {
        // 56.02424270309989, 12.709295987319322
        // 56.02411239732838, 12.709241653235335
        double lat = 56.02411239732838;
        double lng = 12.709241653235335;
        Exercise e = makeExercise10();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Gymmet övning ankelböj och step
    public Station makeStationGym_2() {
        // 5656.024077480096295, 12.709252234567051
        double lat = 56.024077480096295;
        double lng = 12.709252234567051;
        Exercise e = makeExercise11();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Gymmet övning 2 armhhäv
    // 56.0240273574548, 12.709205029445108
    public Station makeStationGym_3() {
        double lat = 56.0240273574548;
        double lng = 12.709205029445108;
        Exercise e = makeExercise12();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Gymmet övning 2 knäböj
    // 56.023994821670264, 12.709190867908525
    public Station makeStationGym_4() {
        double lat = 56.023994821670264;
        double lng = 12.709190867908525;
        Exercise e = makeExercise13();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Gymmet övning 2 tåhäv
    // 56.02393590545007, 12.709156250819099
    public Station makeStationGym_5() {
        double lat = 56.02393590545007;
        double lng = 12.709156250819099;
        Exercise e = makeExercise14();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }


    // Boulebanan rotation
    public Station makeStationBoule_1() {
        // 56.0235621810564, 12.708693640628137
        double lat = 56.0235621810564;
        double lng = 12.708693640628137;
        Exercise e = makeExercise15();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Boulebanan sträck fram
    public Station makeStationBoule_2() {
        // 56.023550749429944, 12.708770742327312
        double lat = 56.023550749429944;
        double lng = 12.708770742327312;
        Exercise e = makeExercise16();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Boulebanan steglängd olika
    public Station makeStationBoule_3() {
        // 56.02356130170063, 12.70881007992893
        double lat = 56.02356130170063;
        double lng = 12.70881007992893;
        Exercise e = makeExercise17();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    // Boulebanan sitt och res
    public Station makeStationBoule_4() {
        // 56.02361758042904, 12.708805359416736
        double lat = 56.02361758042904  ;
        double lng = 12.708805359416736;
        Exercise e = makeExercise18();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }


    public Station makeStation11() {
        double lat = 56.027524970097176;
        double lng = 12.71084231767721;
        Exercise e = makeExercise11();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    public Station makeStation12() {
        double lat = 56.027524970097176;
        double lng = 12.71084231767721;
        Exercise e = makeExercise12();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }


    public Station makeStation13() {
        double lat = 56.02754802425682;
        double lng = 12.711721594921109;
        Exercise e = makeExercise13();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    public Station makeStation14() {
        double lat = 56.027524970097176;
        double lng = 12.71084231767721;
        Exercise e = makeExercise14();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    public Station makeStation15() {
        double lat = 56.027524970097176;
        double lng = 12.71084231767721;
        Exercise e = makeExercise15();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    public Station makeStation16() {
        double lat = 56.027524970097176;
        double lng = 12.71084231767721;
        Exercise e = makeExercise16();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    public Station makeStation17() {
        double lat = 56.027524970097176;
        double lng = 12.71084231767721;
        Exercise e = makeExercise17();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    public Station makeStation18() {
        double lat = 56.027524970097176;
        double lng = 12.71084231767721;
        Exercise e = makeExercise18();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    public Station makeStation19() {
        double lat = 56.027524970097176;
        double lng = 12.71084231767721;
        Exercise e = makeExercise19();
        String desc = e.getName();
        Station s = new Station(desc, desc,
                e, false, lat, lng);
        return s;
    }

    public void makeRound() {
        ArrayList<Station> stations = new ArrayList<>();
        stations.add(makeStationStart_1());
        stations.add(makeStationStart_2());
        stations.add(makeStationStart_3());
        stations.add(makeStationStart_4());
        stations.add(makeStation3());
        stations.add(makeStation4());
        stations.add(makeStation5());
        stations.add(makeStation6());
        stations.add(makeStationGym_1());
        stations.add(makeStationGym_2());
        stations.add(makeStationGym_3());
        stations.add(makeStationGym_4());
        stations.add(makeStationGym_5());

        stations.add(makeStationBoule_1());
        stations.add(makeStationBoule_2());
        stations.add(makeStationBoule_3());
        stations.add(makeStationBoule_4());

//        stations.add(makeStation19());


        String desc = "En lätt runda i trevlig och lummig miljö. Vi går längs Tallskogsleden och förbi ett utegym";
        Round r = new Round("Rosenknoppen", desc);
        r.setDistance("1 km");
        r.setDurationInMinutes(30);
        r.setStations(stations);

        writeToCloud(r);
    }

    private void writeToCloud(Round round) {
        // video clips are stored in firebase storage, and links in realtime database
        fbDatabaseReference = FirebaseDatabase.getInstance().getReference("data/rounds");
        fbDatabaseReference.child(round.getName()).setValue(round);

    }
}
