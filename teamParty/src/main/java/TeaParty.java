enum PartyRating {
    GOOD, BAD, GREAT
}

public class TeaParty {

    public static void main(String[] args) {
        //wywołanie teaParty ma zwracać GOOD jeśli
        //na przyjęciu liczba cukierków i herbat jest conajmniej 5
        //jeśli conajmniej któregoś z dóbr jest 2x więcej niż
        //tego drugiego i oba są > 5 to przyjęcie jest GREAT
        //w przeciwnym wypadku przyjęcie się nie udało (BAD).

        System.out.println(teaParty(5, 6));
        System.out.println(teaParty(1, 20));
        System.out.println(teaParty(6, 12));
    }

    public static PartyRating teaParty(int candy, int tea) {
        if (candy < 5 || tea < 5) {
            return PartyRating.BAD;
        } else if (candy / tea >= 2 || tea / candy >= 2) {
            return PartyRating.GREAT;
        } else {
            return PartyRating.GOOD;
        }
    }
}
