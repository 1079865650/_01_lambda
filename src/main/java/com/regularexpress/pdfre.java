//package com.regularexpress;
//
//public class pdfre {
//    String text = CollectionUtil.join(allText,":::::");
//            System.out.println(text);
//    //1.Aangiftenummer  Datum  Aanvaardingsdatum
//    String Aangiftenummer = "";
//    String Datum = "";
//    String Aanvaardingsdatum = "";
//    Pattern pattern = Pattern.compile(":::::Aangiftenummer:::::: (.*?) Datum: (.*?):::::Aanvaardingsdatum:::::: (.*?) Tijdstip:");
//    Matcher matcher = pattern.matcher(text);
//            if(matcher.find()){
//        Aangiftenummer = matcher.group(1);
//        Datum = matcher.group(2);
//        Aanvaardingsdatum = matcher.group(3);
//    }
//    pattern = Pattern.compile("Artikel: (\\d)(.*?):::::Goederencode: (\\d*):::::(.*?):::::Middel:(.*?):::::Belastbare maatstaf:(.*?):::::Tarief:(.*?):::::Middel: (.*?):::::Belastbare maatstaf:(.*?):::::Tarief: (.*?):::::(.*?)Douanerechten op industrieproducten( ||::::::?)€(.*?)€(.*?):::::");
//    matcher = pattern.matcher(text);
//    List<Map> matchList = new ArrayList<>();
//
//
//            while (matcher.find()){
//        Map<String,String> artikelMap = new HashMap<>();
//        artikelMap.put("artikel",matcher.group(1));
//        artikelMap.put("Goederencode",matcher.group(3));
//        artikelMap.put("Name",matcher.group(4));
//        artikelMap.put("Middle1",matcher.group(5));
//        artikelMap.put("Belastbare1",matcher.group(6));
//        artikelMap.put("Tarief1",matcher.group(7));
//        artikelMap.put("Middle2",matcher.group(8));
//        artikelMap.put("Belastbare2",matcher.group(9));
//        artikelMap.put("Tarief2",matcher.group(10));
//        artikelMap.put("Douanerechten",matcher.group(14));
//        matchList.add(artikelMap);
//    }
//    //解析bedrag
//    pattern = Pattern.compile("::::::Bedrag: (.*?):::::EINDE");
//    matcher = pattern.matcher(text);
//    String bedrag = "";
//            if(matcher.find()) {
//        bedrag = matcher.group(1);
//    }
//    //第二大模块 TOESTEMMING TOT WEGVOERING 开始进行正则匹配
//    //1.MRN
//    pattern = Pattern.compile("(:::::MRN: )(.*?)(:::::)");
//    matcher = pattern.matcher(text);
//    String mrn = "";
//            if(matcher.find()){
//        System.out.println(matcher.groupCount());
//        mrn = matcher.group(2);
//    }
//    //2. Geadresseerde(8)
//    pattern = Pattern.compile("Geadresseerde(.*?):::::(.*?):::::(.*?):::::");
//    matcher = pattern.matcher(text);
//    String geadresseerde = "";
//            if(matcher.find()) {
//        System.out.println(matcher.groupCount());
//        geadresseerde = matcher.group(3);
//
//    }
//    //3.匹配Totaal Colli  Datum van afgifte:
//    pattern = Pattern.compile("Datum van afgifte::::::(.*?):::::(.*?) (.*?) (.*?):::::");
//    matcher = pattern.matcher(text);
//    String totaalColli = "";
//    String datumVanAfgifte = "";
//            if(matcher.find()){
//        System.out.println(matcher.groupCount());
//        totaalColli = matcher.group(3);
//        datumVanAfgifte = matcher.group(4);
//    }
//
//
//    //4.匹配 Vertegenwooddiger Vertegenwoordiger (.*? )(.*?):::::
//    pattern = Pattern.compile("Vertegenwoordiger (.*?) (.*?):::");
//    matcher = pattern.matcher(text);
//    String vertegenwoordiger = "";
//            if(matcher.find()) {
//        System.out.println(matcher.groupCount());
//        vertegenwoordiger = matcher.group(2);
//    }
//    //匹配TOESTEMMING 里面的Artikel
//    pattern = Pattern.compile("Artikel: (\\d).(::::)?Regeling:(.*?):::::Verbijzondering:(.*?)Bruto:(.*?)(:::::)?Netto: (.*?) (.*?):::::CT -(\\d+) -(.*?)Goederencode: (\\d+):::::(.*?):::::(.*?)Containers: (.*?):::::");
//    matcher = pattern.matcher(text);
//    List<Map> artikelList = new ArrayList<>();
//            while (matcher.find()){
//        Map<String,Object> map = new HashMap<>();
//        map.put("artikel",matcher.group(1));
//        map.put("Bruto",matcher.group(5));
//        map.put("Netto",matcher.group(7));
//        map.put("CT",matcher.group(9));
//        map.put("Goederencode",matcher.group(11));
//        map.put("Name",matcher.group(12));
//        map.put("Containers",matcher.group(14));
//        artikelList.add(map);
//    }
//
//    //三大模块  匹配WISPEX的数据
//    pattern = Pattern.compile("IMPORTEUR: VERTRETENER::::::(EUZIEL.*?) (EUZIEL.*?):::::");
//    matcher = pattern.matcher(text);
//    String importeur = "";
//            if(matcher.find()){
//        importeur = matcher.group(1);
//
//    }
//
//    pattern = Pattern.compile("RECHNUNGSNUMMER: (.*?)BETRAG::::::(.*?) ");
//    matcher = pattern.matcher(text);
//    String rechnungsnummer = "";
//            if(matcher.find()) {
//        rechnungsnummer = matcher.group(2);
//
//    }
//
//    pattern = Pattern.compile("CONTAINERNUMMER: (.*?)::::::(.*?) ");
//    matcher = pattern.matcher(text);
//    String containernummber ="";
//            if(matcher.find()) {
//        containernummber = matcher.group(2);
//    }
//
//    //数据表格计算
//    pattern = Pattern.compile("ARTIKELNUMMER (:::::)?:( )?(\\d)(::::::)?(.*?)BRUTTOMASSE:::::::::::(\\d+):::::ZOLLVERFAHREN :(:::::)?(.*?)EIGENMASSE(:::::)?::::::(.*?):::::ZOLLTARIFNUMMER :(:::::)?( )?(.*?)(:::::)?BESONDERE MAßEINHEIT:::::::::::(.*?):::::WARENBESCHREIBUNG (:::::)?:( )?(.*?):::::(.*?)UMRECHNUNGSKURS::::::((.*?))(ZOLLWERT.*?INSGESAMT PER ARTIKEL:::::€( )?(:::::)?(.*?)):::::");
//    matcher = pattern.matcher(text);
//    List wispexTable = new ArrayList();
//            while (matcher.find()){
//        HashMap wispex = new HashMap();
//        System.out.println("wispex:" + matcher.groupCount());
//        wispex.put("ARTIKELNUMMER",matcher.group(3));
//        wispex.put("BRUTTOMASSE",matcher.group(6));
//        wispex.put("EIGENMASSE",matcher.group(10));
//        wispex.put("ZOLLTARIFNUMMER",matcher.group(13));
//        wispex.put("BESONDERE MAßEINHEIT",matcher.group(15));
//        wispex.put("WARENBESCHREIBUNG",matcher.group(18));
//        //列表
//        String tableStr = matcher.group(21);
//        List tablelist = new ArrayList();
//        Pattern tablePattern = Pattern.compile("(.*?)( )?(:::::)?EUR( )?(:::::)?(\\d+,?\\d*)( )?(:::::)?(.*?):::::€(:::::)?( )?(.*?):::::");
//        Matcher  tableMatch = tablePattern.matcher(tableStr);
//        while (tableMatch.find()){
//            Map<String,Object> map = new HashMap();
//            map.put("title",tableMatch.group(1));
//            map.put("currency","EUR");
//            map.put("price",tableMatch.group(6));
//            map.put("quantity",tableMatch.group(9));
//            map.put("total",tableMatch.group(12));
//            tablelist.add(map);
//        }
//        wispex.put("table",tablelist);
//        //替换字符处理
//        String summaryStr = matcher.group(22);
//        Pattern summaryPattern = Pattern.compile("ZOLLWERT:::::€( )?(:::::)?(.*?):::::ZÖLLE AUF INDUSTRIEPRODUKTE:::::(.*?):::::€( )?(:::::)?(.*?):::::BTW \\(NIEDERLÄNDISCHE EUST\\):::::€( )?(:::::)?(.*?):::::INSGESAMT PER ARTIKEL:::::€( )?(:::::)?(.*)");
//        Matcher summaryMatch = summaryPattern.matcher(summaryStr);
//        if(summaryMatch.find()) {
//            wispex.put("ZOLLWERT",summaryMatch.group(3));
//            wispex.put("ZÖLLE AUF INDUSTRIEPRODUKTE SUMMARY",summaryMatch.group(4));
//            wispex.put("ZÖLLE AUF INDUSTRIEPRODUKTE",summaryMatch.group(7));
//            wispex.put("BTW", summaryMatch.group(10));
//            wispex.put("INSGESAMT PER ARTIKEL",summaryMatch.group(13));
//        }
//
////            wispex.put("Other",matcher.group(19));
////            wispex.put("Other1",matcher.group(20));
////            wispex.put("Other2",matcher.group(21));
////            wispex.put("Other3",matcher.group(22));
////            wispex.put("Other4",matcher.group(23));
////            wispex.put("Other5",matcher.group(24));
////            wispex.put("Other6",matcher.group(25));
//        wispexTable.add(wispex);
//    }
//
//            pdfMap.put("Aangiftenummer",Aangiftenummer);
//            pdfMap.put("Datum",Datum);
//            pdfMap.put("Aanvaardingsdatum" , Aanvaardingsdatum);
//            pdfMap.put("Artikel",matchList);
//            pdfMap.put("bedrag", bedrag);
//    //下一个模块
//            pdfMap.put("MRN",mrn);
//            pdfMap.put("Geadresseerde",geadresseerde);
//            pdfMap.put("Totaal Colli",totaalColli);
//            pdfMap.put("Datum van afgifte",datumVanAfgifte);
//            pdfMap.put("Vertegenwooddiger",vertegenwoordiger);
//            pdfMap.put("TOESTEMMING Artikel" ,artikelList);
//    //下一个模块
//            pdfMap.put("Importeur",importeur);
//            pdfMap.put("Rechnungsnummer" , rechnungsnummer);
//            pdfMap.put("Containernummber", containernummber);
//
//            pdfMap.put("wispexTable", wispexTable);
//
//            pdfList.add(pdfMap);
//}
//}
