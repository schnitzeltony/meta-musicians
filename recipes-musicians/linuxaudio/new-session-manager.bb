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
SRCREV = "fb380bf7253096620e166d4abafa45cd830eeedd"
PV = "1.4.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit meson gtk-icon-cache

RCONFLICTS_${PN} = "non-session-manager"
RREPLACES_${PN} = "non-session-manager"
