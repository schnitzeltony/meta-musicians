SUMMARY = "Lightweight Spotify client using Qt"
HOMEPAGE = "https://github.com/kraxarn/spotify-qt"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://license;md5=e49f4652534af377a713df3d9dec60cb"

SRC_URI = "git://github.com/kraxarn/spotify-qt.git"
SRCREV = "59fcf9bd1d53a61b5d60977bbf5aefa01bddbbb0"
S = "${WORKDIR}/git"
PV = "3.2"

DEPENDS = " \
    qtbase \
    qtsvg \
"

inherit cmake_qt5 gtk-icon-cache

RRECOMMENDS_${PN} = "spotifyd"
