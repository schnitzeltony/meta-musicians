SUMMARY = "Lightweight Spotify client using Qt"
HOMEPAGE = "https://github.com/kraxarn/spotify-qt"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://license;md5=e49f4652534af377a713df3d9dec60cb"

SRC_URI = "git://github.com/kraxarn/spotify-qt.git"
SRCREV = "f732c50112c48b73bd30b7c2e27e373da6e593b0"
S = "${WORKDIR}/git"
PV = "3.3"

DEPENDS = " \
    qtbase \
    qtsvg \
"

inherit cmake_qt5 gtk-icon-cache

RRECOMMENDS_${PN} = "spotifyd"
