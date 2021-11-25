package com.example.mobileprogramming_team6;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class url {


    // 버튼 클릭시 사이트 이동

    // android:onClicked = "onButton2Clicked " ( xml)
    public void onButton2Clicked(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("url"));
        // startActivity(intent);
    }

    // textview 클릭시 사이트 이동

    // android:onClicked = " btn" (xml)
    // android:clickable = "true" (xml)
    public void btn(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("url"));
        // startActivity(intent);
    }

}

// 기업 정보 사이트
//1월
    //레인보우로보틱스 http://www.38.co.kr/html/fund/?o=v&no=1615&l=&page=1
//    public void 레인보우로보틱스(View view) {
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.38.co.kr/html/fund/?o=v&no=1615&l=&page=1"));
//        // startActivity(intent);
//    }

//        모비릭스 http://www.38.co.kr/html/fund/?o=v&no=1617&l=&page=1
//    public void 모비릭스(View view) {
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.38.co.kr/html/fund/?o=v&no=1617&l=&page=1"));
//        // startActivity(intent);
//    }

//        선진뷰티사이언스 http://www.38.co.kr/html/fund/?o=v&no=1614&l=&page=1
//        솔루엠 http://www.38.co.kr/html/fund/?o=v&no=1620&l=&page=1
//        신한스팩7호 http://www.38.co.kr/html/fund/?o=v&no=1623&l=&page=1
//        씨앤투스성진 http://www.38.co.kr/html/fund/?o=v&no=1618&l=&page=1
//        엔비티 http://www.38.co.kr/html/fund/?o=v&no=1596&l=&page=1
//        와이더플래닛 http://www.38.co.kr/html/fund/?o=v&no=1610&l=&page=1
//        프레스티지바이오파마 http://www.38.co.kr/html/fund/?o=v&no=1605&l=&page=1
//        핑거 http://www.38.co.kr/html/fund/?o=v&no=1619&l=&page=1
//        한국스팩9호 http://www.38.co.kr/html/fund/?o=v&no=1616&l=&page=1
//
//        2월
//        IBKS스팩15호 http://www.38.co.kr/html/fund/?o=v&no=1631&l=&page=1
//        나노씨엠에스 http://www.38.co.kr/html/fund/?o=v&no=1628&l=&page=1
//        레인보우로보틱스 http://www.38.co.kr/html/fund/?o=v&no=1615&l=&page=1
//        뷰노 http://www.38.co.kr/html/fund/?o=v&no=1621&l=&page=1
//        솔루엠 http://www.38.co.kr/html/fund/?o=v&no=1620&l=&page=1
//        신한스팩7호 http://www.38.co.kr/html/fund/?o=v&no=1623&l=&page=1
//        씨이랩 http://www.38.co.kr/html/fund/?o=v&no=1622&l=&page=1
//        아이퀘스트 http://www.38.co.kr/html/fund/?o=v&no=1624&l=&page=1
//        오로스테크놀로지 http://www.38.co.kr/html/fund/?o=v&no=1632&l=&page=1
//        와이더플래닛 http://www.38.co.kr/html/fund/?o=v&no=1610&l=&page=1
//        유일에너테크 http://www.38.co.kr/html/fund/?o=v&no=1625&l=&page=1
//        프레스티지바이오파마 http://www.38.co.kr/html/fund/?o=v&no=1605&l=&page=1
//        피엔에이치테크 http://www.38.co.kr/html/fund/?o=v&no=1630&l=&page=1
//        하나금융스팩17호 http://www.38.co.kr/html/fund/?o=v&no=1627&l=&page=1
//        하나머스트스팩7호 http://www.38.co.kr/html/fund/?o=v&no=1636&l=&page=1
//
//        3월
//        SK바이오사이언스 http://www.38.co.kr/html/fund/?o=v&no=1641&l=&page=1
//        나노씨엠에스 http://www.38.co.kr/html/fund/?o=v&no=1628&l=&page=1
//        네오이뮨텍 http://www.38.co.kr/html/fund/?o=v&no=1629&l=&page=1
//        디비금융스팩9호 http://www.38.co.kr/html/fund/?o=v&no=1640&l=&page=1
//        라이프시맨틱스 http://www.38.co.kr/html/fund/?o=v&no=1634&l=&page=1
//        바이오다인 http://www.38.co.kr/html/fund/?o=v&no=1635&l=&page=1
//        싸이버원 http://www.38.co.kr/html/fund/?o=v&no=1638&l=&page=1
//        엔시스 http://www.38.co.kr/html/fund/?o=v&no=1643&l=&page=1
//        유안타스팩8호 http://www.38.co.kr/html/fund/?o=v&no=1639&l=&page=1
//        유진스팩6호 http://www.38.co.kr/html/fund/?o=v&no=1646&l=&page=1
//        자이언트스텝 http://www.38.co.kr/html/fund/?o=v&no=1633&l=&page=1
//        제노코 http://www.38.co.kr/html/fund/?o=v&no=1642&l=&page=1
//        프레스티지바이오로직스 http://www.38.co.kr/html/fund/?o=v&no=1637&l=&page=1
//        하나머스트스팩7호 http://www.38.co.kr/html/fund/?o=v&no=1636&l=&page=1
//
//        4월
//        SK아이이테크놀로지 http://www.38.co.kr/html/fund/?o=v&no=1653&l=&page=1
//        엔시스 http://www.38.co.kr/html/fund/?o=v&no=1643&l=&page=1
//        유안타스팩8호 http://www.38.co.kr/html/fund/?o=v&no=1639&l=&page=1
//        유진스팩6호 http://www.38.co.kr/html/fund/?o=v&no=1646&l=&page=1
//        이삭엔지니어링 http://www.38.co.kr/html/fund/?o=v&no=1649&l=&page=1
//        쿠콘 http://www.38.co.kr/html/fund/?o=v&no=1650&l=&page=1
//        하이스팩6호 http://www.38.co.kr/html/fund/?o=v&no=1652&l=&page=1
//        해성티피씨 http://www.38.co.kr/html/fund/?o=v&no=1644&l=&page=1
//
//        5월
//        NH스팩19호 http://www.38.co.kr/html/fund/?o=v&no=1660&l=&page=1
//        SK아이이테크놀로지 http://www.38.co.kr/html/fund/?o=v&no=1653&l=&page=1
//        삼성스팩4호 http://www.38.co.kr/html/fund/?o=v&no=1658&l=&page=1
//        삼영에스앤씨 http://www.38.co.kr/html/fund/?o=v&no=1651&l=&page=1
//        샘씨엔에스 http://www.38.co.kr/html/fund/?o=v&no=1657&l=&page=1
//        씨앤씨인터내셔널 http://www.38.co.kr/html/fund/?o=v&no=1655&l=&page=1
//        에이디엠코리아 http://www.38.co.kr/html/fund/?o=v&no=1661&l=&page=1
//        에이치피오 http://www.38.co.kr/html/fund/?o=v&no=1648&l=&page=1
//        제주맥주 http://www.38.co.kr/html/fund/?o=v&no=1654&l=&page=1
//        진시스템 http://www.38.co.kr/html/fund/?o=v&no=1659&l=&page=1
//        하이스팩6호 http://www.38.co.kr/html/fund/?o=v&no=1652&l=&page=1
//
//        6월
//        라온테크 http://www.38.co.kr/html/fund/?o=v&no=1666&l=&page=1
//        삼성머스트스팩5호 http://www.38.co.kr/html/fund/?o=v&no=1664&l=&page=1
//        아모센스 http://www.38.co.kr/html/fund/?o=v&no=1647&l=&page=1
//        에이디엠코리아 http://www.38.co.kr/html/fund/?o=v&no=1661&l=&page=1
//        엘비루셈 http://www.38.co.kr/html/fund/?o=v&no=1662&l=&page=1
//        이노뎁 http://www.38.co.kr/html/fund/?o=v&no=1663&l=&page=1
//
//        7월
//        맥스트 http://www.38.co.kr/html/fund/?o=v&no=1668&l=&page=1
//        에브리봇 http://www.38.co.kr/html/fund/?o=v&no=1669&l=&page=1
//        에스디바이오센서 http://www.38.co.kr/html/fund/?o=v&no=1667&l=&page=1
//        에이치케이이노엔 http://www.38.co.kr/html/fund/?o=v&no=1678&l=&page=1
//        오비고 http://www.38.co.kr/html/fund/?o=v&no=1665&l=&page=1
//        카카오뱅크 http://www.38.co.kr/html/fund/?o=v&no=1676&l=&page=1
//        큐라클 http://www.38.co.kr/html/fund/?o=v&no=1670&l=&page=1
//        한화플러스스팩2호 http://www.38.co.kr/html/fund/?o=v&no=1679&l=&page=1
//
//        8월
//        IBKS스팩16호 http://www.38.co.kr/html/fund/?o=v&no=1689&l=&page=1
//        디앤디플랫폼리츠 http://www.38.co.kr/html/fund/?o=v&no=1688&l=&page=1
//        딥노이드 http://www.38.co.kr/html/fund/?o=v&no=1674&l=&page=1
//        롯데렌탈 http://www.38.co.kr/html/fund/?o=v&no=1685&l=&page=1
//        바이젠셀 http://www.38.co.kr/html/fund/?o=v&no=1677&l=&page=1
//        브레인즈컴퍼니 http://www.38.co.kr/html/fund/?o=v&no=1672&l=&page=1
//        아주스틸 http://www.38.co.kr/html/fund/?o=v&no=1683&l=&page=1
//        에이비온 http://www.38.co.kr/html/fund/?o=v&no=1686&l=&page=1
//        에이치케이이노엔 http://www.38.co.kr/html/fund/?o=v&no=1678&l=&page=1
//        엠로 http://www.38.co.kr/html/fund/?o=v&no=1680&l=&page=1
//        원티드랩 http://www.38.co.kr/html/fund/?o=v&no=1675&l=&page=1
//        일진하이솔루스 http://www.38.co.kr/html/fund/?o=v&no=1684&l=&page=1
//        카카오뱅크 http://www.38.co.kr/html/fund/?o=v&no=1676&l=&page=1
//        크래프톤 http://www.38.co.kr/html/fund/?o=v&no=1671&l=&page=1
//        플래티어 http://www.38.co.kr/html/fund/?o=v&no=1673&l=&page=1
//        한컴라이프케어 http://www.38.co.kr/html/fund/?o=v&no=1681&l=&page=1
//        한화플러스스팩2호 http://www.38.co.kr/html/fund/?o=v&no=1679&l=&page=1
//
//        9월
//        IBKS스팩16호 http://www.38.co.kr/html/fund/?o=v&no=1689&l=&page=1
//        NH스팩20호 http://www.38.co.kr/html/fund/?o=v&no=1692&l=&page=1
//        SK리츠 http://www.38.co.kr/html/fund/?o=v&no=1698&l=&page=1
//        대신밸런스스팩10호 http://www.38.co.kr/html/fund/?o=v&no=1693&l=&page=1
//        바이오플러스 http://www.38.co.kr/html/fund/?o=v&no=1699&l=&page=1
//        신한스팩8호 http://www.38.co.kr/html/fund/?o=v&no=1694&l=&page=1
//        실리콘투 http://www.38.co.kr/html/fund/?o=v&no=1700&l=&page=1
//        씨유테크 http://www.38.co.kr/html/fund/?o=v&no=1706&l=&page=1
//        아스플로 http://www.38.co.kr/html/fund/?o=v&no=1704&l=&page=1
//        에스앤디 http://www.38.co.kr/html/fund/?o=v&no=1687&l=&page=1
//        에이비온 http://www.38.co.kr/html/fund/?o=v&no=1686&l=&page=1
//        와이엠텍 http://www.38.co.kr/html/fund/?o=v&no=1691&l=&page=1
//        원준 http://www.38.co.kr/html/fund/?o=v&no=1702&l=&page=1
//        유진스팩7호 http://www.38.co.kr/html/fund/?o=v&no=1690&l=&page=1
//        일진하이솔루스 http://www.38.co.kr/html/fund/?o=v&no=1684&l=&page=1
//        프롬바이오 http://www.38.co.kr/html/fund/?o=v&no=1701&l=&page=1
//        하나금융스팩19호 http://www.38.co.kr/html/fund/?o=v&no=1703&l=&page=1
//        현대중공업 http://www.38.co.kr/html/fund/?o=v&no=1696&l=&page=1
//
//        10월
//        NH스팩20호 http://www.38.co.kr/html/fund/?o=v&no=1692&l=&page=1
//        NH스팩21호 http://www.38.co.kr/html/fund/?o=v&no=1697&l=&page=1
//        리파인 http://www.38.co.kr/html/fund/?o=v&no=1705&l=&page=1
//        씨유테크 http://www.38.co.kr/html/fund/?o=v&no=1706&l=&page=1
//        아스플로 http://www.38.co.kr/html/fund/?o=v&no=1704&l=&page=1
//        아이패밀리에으씨 http://www.38.co.kr/html/fund/?o=v&no=1712&l=&page=1
//        엔켐 http://www.38.co.kr/html/fund/?o=v&no=1714&l=&page=1
//        원준 http://www.38.co.kr/html/fund/?o=v&no=1702&l=&page=1
//        지니너스 http://www.38.co.kr/html/fund/?o=v&no=1716&l=&page=1
//        지아이텍 http://www.38.co.kr/html/fund/?o=v&no=1710&l=&page=1
//        지앤비에스엔지니어링 http://www.38.co.kr/html/fund/?o=v&no=1713&l=&page=1
//        차백신연구소 http://www.38.co.kr/html/fund/?o=v&no=1695&l=&page=1
//        카카오페이 http://www.38.co.kr/html/fund/?o=v&no=1682&l=&page=1
//        케이카 http://www.38.co.kr/html/fund/?o=v&no=1707&l=&page=1
//        피코그램 http://www.38.co.kr/html/fund/?o=v&no=1715&l=&page=1
//        하나금융스팩19호 http://www.38.co.kr/html/fund/?o=v&no=1703&l=&page=1
//
//        11월
//        NH올원리츠 http://www.38.co.kr/html/fund/?o=v&no=1723&l=&page=1
//        대신밸런스스팩11호 http://www.38.co.kr/html/fund/?o=v&no=1725&l=&page=1
//        디어유 http://www.38.co.kr/html/fund/?o=v&no=1717&l=&page=1
//        마인즈랩 http://www.38.co.kr/html/fund/?o=v&no=1724&l=&page=1
//        미래에셋글로벌리츠 http://www.38.co.kr/html/fund/?o=v&no=1727&l=&page=1
//        바이옵트로 http://www.38.co.kr/html/fund/?o=v&no=1721&l=&page=1
//        신한서부티엔디리츠 http://www.38.co.kr/html/fund/?o=v&no=1728&l=&page=1
//        아이티아이즈 http://www.38.co.kr/html/fund/?o=v&no=1718&l=&page=1
//        알비더블유 http://www.38.co.kr/html/fund/?o=v&no=1722&l=&page=1
//        엔켐 http://www.38.co.kr/html/fund/?o=v&no=1714&l=&page=1
//        지니너스 http://www.38.co.kr/html/fund/?o=v&no=1716&l=&page=1
//        지오엘리먼트 http://www.38.co.kr/html/fund/?o=v&no=1711&l=&page=1
//        카카오페이 http://www.38.co.kr/html/fund/?o=v&no=1682&l=&page=1
//        트윔 http://www.38.co.kr/html/fund/?o=v&no=1720&l=&page=1
//        피코그램 http://www.38.co.kr/html/fund/?o=v&no=1715&l=&page=1
//
//        12월
//        교보스팩11호 http://www.38.co.kr/html/fund/?o=v&no=1731&l=&page=1
//        대신밸런스스팩11호 http://www.38.co.kr/html/fund/?o=v&no=1725&l=&page=1
//        래몽래인 http://www.38.co.kr/html/fund/?o=v&no=1733&l=&page=1
//        미래에셋글로벌리츠 http://www.38.co.kr/html/fund/?o=v&no=1727&l=&page=1
//        신한서부티엔디리츠 http://www.38.co.kr/html/fund/?o=v&no=1728&l=&page=1
//        오토앤 http://www.38.co.kr/html/fund/?o=v&no=1732&l=&page=1
//        케이티비네트워크 http://www.38.co.kr/html/fund/?o=v&no=1726&l=&page=1
//        툴젠 http://www.38.co.kr/html/fund/?o=v&no=1730&l=&page=1
//        하나금융스팩20호 http://www.38.co.kr/html/fund/?o=v&no=1734&l=&page=1
//        하이스팩7호 http://www.38.co.kr/html/fund/?o=v&no=1729&l=&page=1
