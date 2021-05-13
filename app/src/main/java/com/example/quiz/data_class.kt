package com.example.quiz

data class data_class(var question:String,
                      var options_list:List<String>,
                        var answerkey :String,
                        var ansId:Int,
                      var opt :Int
                        )
val q_01 =data_class(
    "Which among the following is not an operating system?",
    listOf( "UNIX","LINUX","OS X","PITEX"),
    "PITEX",
    R.string.ans_01,
    3
)
val q_02 =data_class(
    "Byte is the series of ……………… bits.",
    listOf( "2","5","8","12"),
    "8",R.string.ans_02,2
)
val q_03 =data_class(
    "While sending an email, sometimes you also add multiple recipients in ‘CC;’ CC stands for …",
    listOf( "Carbon copy",
        "Creative copy",
        "Carbon common",
        "Creative common"),
    "Carbon copy",
    R.string.ans_03,0
)
val q_04 =data_class(
    "ISP stands for:",
    listOf( "Internet Survey Period",
        "Integrated Service Provider",
        "Internet Security Protocol",
        "Internet Service Provider"),
    "Internet Service Provider",
    R.string.ans_04,3
)
val q_05 =data_class(
    "The \"http\" you type at the beginning of any site's address stands for:",
    listOf( "HTML Transfer Technology Process",
        "Hyperspace Terms and Tech Protocol",
        "Hyperspace Techniques & Tech Progress",
        "Hyper Text Transfer Protocol"),
    "Hyper Text Transfer Protocol",
    R.string.ans_05,3
)
val q_06 =data_class(
    "'.JPG' extension refers usually to what kind of file?",
    listOf( "System file",
        "Animation/movie file",
        "MS Encarta document",
        "Image file"),
    "Image file",
    R.string.ans_06,3
)
val q_07 =data_class(
    "What was the first ARPANET message?",
    listOf( "\"lo\"",
        " \"hello world\"",
        "\"mary had a little lamb\"",
        "\"cyberspace, the final frontier\""),
    "\"lo\" ",
    R.string.ans_07,0
)
val q_08 =data_class(
    "'.BAK' extension refers usually to what kind of file?",
    listOf( "Backup file",
        "Audio file",
        "Animation/movie file",
        "MS Encarta document"),
    "Backup file ",
    R.string.ans_08,0
)

val q_10 =data_class(
    "Which of the following is not a computer language?",
    listOf( "Windows 98",
        " PASCAL",
        "FORTRAN",
        "C++"),
    "Windows 98",
    R.string.ans_10,0
)
val q_11=data_class(
    "Modem stands for:",
    listOf( "Modulator Demodulator",
        "  Monetary Devaluation Exchange Mechanism",
        "Memory Demagnetization",
        "Monetary Demarcation"),
    "Modulator Demodulator ",
    R.string.ans_11,0
)
val q_12 =data_class(
    "What is the difference between the Internet and an intranet?",
    listOf( " One is public, the other is private",
        " One is safer than the other",
        "One can be monitored, the other can't",
        " None of the above"),
    "One is public, the other is private",
    R.string.ans_12,0
)
val q_13 =data_class(
    "What do you call a computer on a network that requests files from another computer?",
    listOf( "A host",
        " A client",
        "A router",
        "A web server"),
    "A client",
    R.string.ans_13,1
)
val q_14 =data_class(
    "Which is not an Internet protocol?",
    listOf( " HTTP",
        " FTP",
        "STP",
        "IP"),
    " STP",
    R.string.ans_14,2
)
val q_21 =data_class(
    "\"www\" stands for:",
    listOf( "World Wide Word",
        " World Wide Wares",
        "World Wide Web",
        "World Wide War"),
    "World Wide Web",
    R.string.ans_21,2
)
val q_15 =data_class(
    "HTML is used to:",
    listOf( " Plot complicated graphs",
        " Author Web Page",
        "Translate one language into another",
        "Solve equationsr"),
    "Author Web Pages",
    R.string.ans_15,1
)
val q_16 =data_class(
    "What is a MAC?",
    listOf( "A client",
        " A host",
        "A router",
        "A web server"),
    "A client",
    R.string.ans_16,0
)
val q_17 =data_class(
    "What does ICMP stand for?",
    listOf( "Internet Connection Modem Protocol",
        "Intranet Control Message Program",
        "Internal Conflict Management Program",
        "Internet Control Message Protocol"),
    "Internet Control Message Protocol",
    R.string.ans_17,3
)
val q_18 =data_class(
    "ARPANET, the precursor to the Internet, was developed by:",
    listOf( " FAA",
        "Department of Defense",
        "NATO",
        "UART"),
    "Department of Defense",
    R.string.ans_18,1
)
val q_19 =data_class(
    "What is a spider?",
    listOf( " A computer virus",
        " A program that catalogs Web sites",
        "A hacker who breaks into computer systems",
        "An application for viewing Web sites"),
    "A program that catalogs Web sites",
    R.string.ans_19,1
)
val q_20 =data_class(
    "The abbreviation URL stands for:",
    listOf(
        "User Regulation Law",
        "Unknown RAM Load",
        "Uniform Resource Locator",
        "Ultimate RAM Locator",
    ),
    "Uniform Resource Locator",
    R.string.ans_20,2
)
class Obj_list{
    fun send_obj():List<data_class>{
        return listOf(q_01, q_02, q_03, q_04, q_05, q_06, q_07, q_08,  q_10, q_11, q_12, q_13,
            q_14, q_15, q_16, q_18, q_17, q_20, q_19, q_21)
    }

}
