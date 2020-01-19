SUMMARY = "Qsampler is a LinuxSampler GUI front-end application"
HOMEPAGE = "http://qsampler.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    liblscp \
    libgig \
"

# autotools-brokensep must be after qmake5_base!
inherit qmake5_base autotools-brokensep gtk-icon-cache qt5-translation mime mime-xdg

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://0001-no-Qt4-find-native-qt-build-tools-by-configure-options-auto.patch \
"
SRC_URI[md5sum] = "cca6eaae7cfbefc116930454bc72fa8e"
SRC_URI[sha256sum] = "12b59cf4d4c21f0e0f4a91395b0017c98f991e300e04b400f856f49fc69927f3"
PV = "0.6.1"

EXTRA_OECONF = " \
    --with-qmake=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/qmake \
    --with-moc=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/moc \
    --with-uic=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/uic \
    --with-lupdate=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/lupdate \
    --with-lrelease=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/lrelease \
"

FILES_${PN} += " \
    ${datadir}/metainfo \
    ${datadir}/mime \
"

#RDEPENDS_${PN} += "jack-server"
