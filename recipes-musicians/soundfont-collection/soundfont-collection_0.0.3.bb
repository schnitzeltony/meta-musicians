SUMMARY = "A collection of free soundfonts"
LICENSE = "GPLv2 & MIT & CC-BY-3.0 & CC0-1.0"
LIC_FILES_CHKSUM = " \
    file://YDP-GrandPiano-SF2-20160804/YDP-GrandPiano-20160804.txt;beginline=6;endline=13;md5=bc4ea1672a4d8fb0b2eb2f95a5d49bf2 \
    file://UprightPianoKW-SF2-20190703/readme.txt;beginline=21;endline=22;md5=b923259da7dc404552b0a300da4afb95 \
    file://SalamanderGrandPiano-SF2-V3+20200602/readme.txt;beginline=12;endline=14;md5=d50da459b6dc1f9ae6b25bb4f38fb676 \
    \
    file://GeneralUser%20GS%201.471/LICENSE.txt;md5=51c5827b75fa15c5e7f6f13290bc5445 \
    \
    file://avl-drumkits/AVL-Drumkits-1.1-fix-SF2/AVL-Drumkits%20CC-BY-SA%20License.pdf;md5=db54d5d5fcba6e9ca3f61185eec10a43 \
    \
    file://linuxaudio.org/airfont_a340u/readme;md5=94c7ebefcd275e72d018acec80b714cf \
    file://linuxaudio.org/fluidr3/readme;md5=4223817a5c95fe5efbe35d0e6b487063 \
    \
    file://archive-rabs/Soundfonts_meta.xml;beginline=11;endline=11;md5=801a564526e0a67ca1344ad076c6497c \
"

DEPENDS = "sf-tools-native"

inherit allarch

# TODO
# https://trisamples.com/free-soundfonts/
# https://sites.google.com/site/soundfonts4u/

SRC_URI = " \
    http://download.linuxaudio.org/musical-instrument-libraries/sf2/airfont_a340u.tar.7z;subdir=linuxaudio.org;name=airfont \
    http://download.linuxaudio.org/musical-instrument-libraries/sf2/fluidr3.tar.7z;subdir=linuxaudio.org;name=fluidr3 \
    http://download.linuxaudio.org/musical-instrument-libraries/sf2/jRhodes3.tar.7z;subdir=linuxaudio.org;name=jRhodes3 \
    http://download.linuxaudio.org/musical-instrument-libraries/sf2/melloflute.tar.7z;subdir=linuxaudio.org;name=melloflute \
    http://download.linuxaudio.org/musical-instrument-libraries/sf2/melloreed.tar.7z;subdir=linuxaudio.org;name=melloreed \
    \
    http://bandshed.net/sounds/sf2/AVL-Drumkits-1.1-fix-SF2.zip;subdir=avl-drumkits;name=avl-drumkits \
    \
    https://freepats.zenvoid.org/Piano/YDP-GrandPiano/YDP-GrandPiano-SF2-20160804.tar.bz2;name=ydp-grand-piano \
    https://freepats.zenvoid.org/Piano/UprightPianoKW/UprightPianoKW-SF2-20190703.tar.xz;name=upright-piano-kw \
    https://freepats.zenvoid.org/Piano/SalamanderGrandPiano/SalamanderGrandPiano-SF2-V3+20200602.tar.xz;name=salamander-grand-piano \
    \
    http://www.philscomputerlab.com/uploads/3/7/2/3/37231621/weedsgm3.sf2;subdir=www.philscomputerlab.com;name=weedsgm3 \
    http://www.philscomputerlab.com/uploads/3/7/2/3/37231621/choriumreva.sf2;subdir=www.philscomputerlab.com;name=choriumreva \
    \
    https://www.dropbox.com/s/4x27l49kxcwamp5/GeneralUser_GS_1.471.zip;name=christiancollins \
    \
    https://musical-artifacts.com/artifacts/248/iw_vint.zip;subdir=musical-artifacts;name=vintage-dreams-waves \
    \
    https://archive.org/download/Soundfonts/RabsBass.sf2;subdir=archive-rabs;name=rabs-bass \
    https://archive.org/download/Soundfonts/RabsBrassSection.sf2;subdir=archive-rabs;name=rabs-brass-section \
    https://archive.org/download/Soundfonts/RabsFenderRhodes.sf2;subdir=archive-rabs;name=rabs-fender-rhodes \
    https://archive.org/download/Soundfonts/RabsHohnerD-6.sf2;subdir=archive-rabs;name=rabs-hohnerD-6 \
    https://archive.org/download/Soundfonts/RabsJazzkit.sf2;subdir=archive-rabs;name=rabs-jazzkit \
    https://archive.org/download/Soundfonts/RabsNewConstructionKit.sf2;subdir=archive-rabs;name=rabs-new-construction-kit \
    https://archive.org/download/Soundfonts/RabsOrgans.sf2;subdir=archive-rabs;name=rabs-organs \
    https://archive.org/download/Soundfonts/RabsStratocaster.sf2;subdir=archive-rabs;name=rabs-stratocaster \
    https://archive.org/download/Soundfonts/RabsWwGtr.sf2;subdir=archive-rabs;name=rabs-wwgtr \
    https://archive.org/download/Soundfonts/Soundfonts_meta.xml;subdir=archive-rabs;name=rabs-meta \
"

SRC_URI[airfont.sha256sum] = "7c61d6243943e3ff86dbe776cf3f1cdb0af5e55ccda370491c02613849fd9df4"
SRC_URI[fluidr3.sha256sum] = "a62235d86c920f141a1aa2a0921ceaee167478796d9e0ac1130fd87ec50a6a02"
SRC_URI[jRhodes3.sha256sum] = "a50462992b19f4df65aa63d237bb0e45a071e63383ae9f2c5a2980d4ec3bcce1"
SRC_URI[melloflute.sha256sum] = "d4fbbab82ee558092e9f6706c9bf865314cf5d848c7a1a076b039926d36cb305"
SRC_URI[melloreed.sha256sum] = "b6f3ff4ccef5e1b4f35b81e915f85ae4fa0730bf01f26151c66ba04efb30d028"

SRC_URI[avl-drumkits.sha256sum] = "46a5d0d1fd3894082ae0ecdab3396a9a1b9eecc0076935f35980cdd7ce024382"

SRC_URI[ydp-grand-piano.sha256sum] = "d243dc3e182a60df2a16e92828c1821cf3eb5748b45e2e2bdcfa9cf7af056026"
SRC_URI[upright-piano-kw.sha256sum] = "e1e4b9777e100664ffb1bee2e0a2884378c329c7125e6dd9fb3971c69759582b"
SRC_URI[salamander-grand-piano.sha256sum] = "15edb061d7ba60d58332f72dba8f8ce40988048cc703f935e6320f37d650e213"

SRC_URI[weedsgm3.sha256sum] = "4de36fdec6a1f972d3b32ac35ff1c3178ceb0fc05ff5c9fb94aebde5197f8568"
SRC_URI[choriumreva.sha256sum] = "993a1683a67f30c56c248290e1eb6c13b779331856e9a767ace0f5063f41f897"

SRC_URI[christiancollins.sha256sum] = "4203835164766f428c4926c097c9ea58dae431c7fb8f9dbe277b92d80da45ec2"

SRC_URI[vintage-dreams-waves.sha256sum] = "2706ec973acc390b888e0084c7afd4ba75da58f2772c13b1e398a6a66b021f15"

SRC_URI[rabs-bass.sha256sum] = "9c66c35ed823e340a79e6dbd35d57e6eaa8d1847af5f8619294eedfe90760c4e"
SRC_URI[rabs-brass-section.sha256sum] = "2b67da6bf2e0a73de578de5884c49061557d83db5603a6494df9eef08752a2ee"
SRC_URI[rabs-fender-rhodes.sha256sum] = "aafbc93874163e6b702fea3ca4cc4ba8fd8b610a13d726813c55c164d8a87c66"
SRC_URI[rabs-hohnerD-6.sha256sum] = "64e476f87fd7ec2d3984b8944f7a17d78023bc1a089cc051a5dbd4d02119a222"
SRC_URI[rabs-jazzkit.sha256sum] = "3636b39e46290beab557ee64e102a731f37f5ed65c36bf025847f68dcfb8f71e"
SRC_URI[rabs-new-construction-kit.sha256sum] = "b3fce24ba733c78afb9bbf12e973d2d8843d2e6fc34ac5b1e46c598cb72d0ec5"
SRC_URI[rabs-organs.sha256sum] = "14765b576626e440caf054c7b3a502b03cd95b451d4e8bf53f623705de8a5174"
SRC_URI[rabs-stratocaster.sha256sum] = "1966c40643b0de18f825fb26f10fdf5aabb298b69268be43d0e5b5c434fd6621"
SRC_URI[rabs-wwgtr.sha256sum] = "a17be1dff75bf76af0ac78e9fec75313a7375ac1e388709546c4e732c1ca1652"
SRC_URI[rabs-meta.sha256sum] = "d3b10719b9bf41f598f7cd9d555c6d4852e0eb3c734ef9694fba0451d091e778"


do_unpack[depends] += "p7zip-native:do_populate_sysroot"

S = "${WORKDIR}"

PACKAGES = " \
    ${PN}-meta \
    ${PN}-avl-drumkits \
    ${PN}-linuxaudio-org \
    ${PN}-linuxaudio-org-single \
    ${PN}-freepats-zenvoid-org \
    ${PN}-freepats-zenvoid-org-salamander-grand \
    ${PN}-philscomputerlab-com \
    ${PN}-philscomputerlab-com-single \
    ${PN}-christiancollins \
    ${PN}-musical-artifacts \
    ${PN}-archive-rabs \
"

ALLOW_EMPTY:${PN}-meta = "1"
RRECOMMENDS:${PN}-meta = " \
    ${PN}-avl-drumkits \
    ${PN}-linuxaudio-org \
    ${PN}-linuxaudio-org-single \
    ${PN}-freepats-zenvoid-org \
    ${PN}-philscomputerlab-com \
    ${PN}-philscomputerlab-com-single \
    ${PN}-christiancollins \
    ${PN}-musical-artifacts \
    ${PN}-archive-rabs \
"
# freepats-zenvoid-org-salamander-grand is 1.3G so don't recommend if for meta

do_configure() {
}

do_install() {
    install -d ${D}${datadir}/sf2

    install ${WORKDIR}/YDP-GrandPiano-SF2-20160804/*.sf2 ${D}${datadir}/sf2
    install ${WORKDIR}/UprightPianoKW-SF2-20190703/*.sf2 ${D}${datadir}/sf2
    install ${WORKDIR}/SalamanderGrandPiano-SF2-V3+20200602/*.sf2 ${D}${datadir}/sf2

    install ${WORKDIR}/www.philscomputerlab.com/*.sf2 ${D}${datadir}/sf2

    install "${WORKDIR}/GeneralUser GS 1.471/GeneralUser GS v1.471.sf2" ${D}${datadir}/sf2/general-user-gs-v1.471.sf2
    for soundfont in `find ${WORKDIR}/avl-drumkits -name '*.sf2'`; do
        install $soundfont ${D}${datadir}/sf2
    done

    for soundfont in `find ${WORKDIR}/linuxaudio.org -name '*.sf2'`; do
        install $soundfont ${D}${datadir}/sf2
    done

    for soundfont in `find ${WORKDIR}/archive-rabs -name '*.sf2'`; do
        install $soundfont ${D}${datadir}/sf2
    done

    # split some GM soundfonts into single files
    install -d ${D}${datadir}/sf2/fluidr3gm-single
    cd ${D}${datadir}/sf2/fluidr3gm-single
    sf2-split ${D}${datadir}/sf2/fluidr3gm.sf2
    
    install -d ${D}${datadir}/sf2/airfont_a320u-single
    cd ${D}${datadir}/sf2/airfont_a320u-single
    sf2-split ${D}${datadir}/sf2/airfont_a320u.sf2

    install -d ${D}${datadir}/sf2/weedsgm3
    cd ${D}${datadir}/sf2/weedsgm3
    sf2-split ${D}${datadir}/sf2/weedsgm3.sf2
}

FILES:${PN}-avl-drumkits = " \
    ${datadir}/sf2/AVL_Drumkits_Perc_1.1.sf2 \
    ${datadir}/sf2/Black_Pearl*.sf2 \
    ${datadir}/sf2/Red_Zeppelin*.sf2 \
"

FILES:${PN}-linuxaudio-org = " \
    ${datadir}/sf2/fluidr3*.sf2 \
    ${datadir}/sf2/airfont_a320u.sf2 \
    ${datadir}/sf2/mello*.sf2 \
    ${datadir}/sf2/jRhodes3.sf2 \
"

FILES:${PN}-linuxaudio-org-single = " \
    ${datadir}/sf2/fluidr3gm-single \
    ${datadir}/sf2/airfont_a320u-single \
"

FILES:${PN}-freepats-zenvoid-org = " \
    ${datadir}/sf2/YDP-GrandPiano-20160804.sf2 \
    ${datadir}/sf2/UprightPianoKW-20190703.sf2 \
"
FILES:${PN}-freepats-zenvoid-org-salamander-grand = " \
    ${datadir}/sf2/SalamanderGrandPiano-V3+20200602.sf2 \
"

FILES:${PN}-philscomputerlab-com = " \
    ${datadir}/sf2/weedsgm3.sf2 \
    ${datadir}/sf2/choriumreva.sf2 \
"

FILES:${PN}-philscomputerlab-com-single = " \
    ${datadir}/sf2/weedsgm3 \
"

FILES:${PN}-christiancollins = "${datadir}/sf2/general-user-gs-v1.471.sf2"

FILES:${PN}-musical-artifacts = "${datadir}/sf2/Vintage-Dreams-Waves-V2.sf2"

FILES:${PN}-archive-rabs = " \
    ${datadir}/sf2/RabsStratocaster.sf2 \
    ${datadir}/sf2/RabsHohnerD-6.sf2 \
    ${datadir}/sf2/RabsBass.sf2 \
    ${datadir}/sf2/RabsOrgans.sf2 \
    ${datadir}/sf2/RabsNewConstructionKit.sf2 \
    ${datadir}/sf2/RabsFenderRhodes.sf2 \
    ${datadir}/sf2/RabsJazzkit.sf2 \
    ${datadir}/sf2/RabsWwGtr.sf2 \
    ${datadir}/sf2/RabsBrassSection.sf2 \
"
