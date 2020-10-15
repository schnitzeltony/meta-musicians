SUMMARY = "Community version of Non Session Manager"
HOMEPAGE = "https://linuxaudio.github.io/new-session-manager/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS = " \
    fltk-native \
    fltk \
    jack \
    liblo \
"

SRC_URI = "git://github.com/linuxaudio/new-session-manager.git"
SRCREV = "de776584362b83240ca324ded978f5c7548e6624"
PV = "1.4.0"
S = "${WORKDIR}/git"

inherit meson gtk-icon-cache

