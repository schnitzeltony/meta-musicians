SUMMARY = "Software synth with a classic subtractive synthesizer topology"
HOMEPAGE = "http://amsynth.github.io/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=67b604758dd265c185ce36fcf76a889d"

inherit autotools pkgconfig gtk-icon-cache gettext pack_audio_plugins

DEPENDS += " \
    gtk+ \
    intltool-native \
"

SRC_URI = "git://github.com/amsynth/amsynth.git;branch=develop"
SRCREV = "4d980f3421f61cc8ea53e92eba5e43e823af7c02"
PV = "1.12.2"
S = "${WORKDIR}/git"

PACKAGECONFIG ??= "alsa jack lv2 nsm"

PACKAGECONFIG[oss] = "--with-oss,--without-oss"
PACKAGECONFIG[alsa] = "--with-alsa,--without-alsa,alsa-lib"
PACKAGECONFIG[dssi] = "--with-dssi,--without-dssi,dssi liblo"
PACKAGECONFIG[jack] = "--with-jack,--without-jack,jack"
PACKAGECONFIG[lv2] = "--with-lv2,--without-lv2,lv2"
PACKAGECONFIG[nsm] = "--with-nsm,--without-nsm,liblo,new-session-manager"

PACKAGES =+ "${PN}-standalone"
FILES_${PN}-standalone += " \
    ${datadir}/appdata/amsynth.appdata.xml \
    ${datadir}/applications \
    ${datadir}/icons \
    ${bindir} \
"

FILES_${PN_DSSI} += " \
    ${datadir}/appdata/dssi-amsynth-plugin.metainfo.xml \
"

FILES_${PN_LV2} += " \
    ${datadir}/appdata/lv2-amsynth-plugin.metainfo.xml \
"

FILES_${PN_VST} += " \
    ${datadir}/appdata/vst-amsynth-plugin.metainfo.xml \
"

RDEPENDS_${PN}-standalone += "${PN}"
RDEPENDS_${PN_DSSI} += "${PN}"
RDEPENDS_${PN_LV2} += "${PN}"
RDEPENDS_${PN_VST} += "${PN}"
