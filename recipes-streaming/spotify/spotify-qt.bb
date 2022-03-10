SUMMARY = "Lightweight Spotify client using Qt"
HOMEPAGE = "https://github.com/kraxarn/spotify-qt"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://license;md5=e49f4652534af377a713df3d9dec60cb"

SRC_URI = "git://github.com/kraxarn/spotify-qt.git;branch=master;protocol=https"
SRCREV = "c8394e55f511aa03abc54c07d475b04969d0fb23"
S = "${WORKDIR}/git"
PV = "3.7"

DEPENDS = " \
    qtbase \
    qtsvg \
"

inherit cmake_qt5 gtk-icon-cache

RRECOMMENDS:${PN} = "spotifyd"
