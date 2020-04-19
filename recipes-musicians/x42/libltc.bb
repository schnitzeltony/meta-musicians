SUMMARY = "Linear/Logitudinal Time Code (LTC) Library"
HOMEPAGE = "http://x42.github.io/libltc/"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=6a6a8e020838b23406c81b19c1d46df6"

inherit autotools

SRC_URI = "git://github.com/x42/libltc.git"
SRCREV = "ea3b2501271a530b05ce169d1824590011d93112"
PV = "1.3.1"
S = "${WORKDIR}/git"
