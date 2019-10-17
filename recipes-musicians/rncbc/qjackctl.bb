SUMMARY = "JACK Audio Connection Kit - Qt GUI Interface"
HOMEPAGE = "http://qjackctl.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    jack \
    qtx11extras \
    portaudio-v19 \
"

# autotools-brokensep must be after qmake5_base!
inherit qmake5_base autotools-brokensep gtk-icon-cache qt5-translation

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://0002-no-Qt4-find-native-qt-build-tools-by-configure-options-auto.patch \
    file://QjackCtl.conf \
"
SRC_URI[md5sum] = "96f9547d61bf963704df988a5074bda0"
SRC_URI[sha256sum] = "9dd5ee9a7f0a2d1d530b10652e09972732dc210239b7c082be816f0e7bdfadcd"
PV = "0.6.0"

EXTRA_OECONF = " \
    --with-qmake=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/qmake \
    --with-moc=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/moc \
    --with-uic=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/uic \
    --with-lupdate=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/lupdate \
    --with-lrelease=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/lrelease \
"

FILES_${PN} += " \
    ${datadir}/metainfo \
"

do_install_append() {
    install -d ${D}/${sysconfdir}/skel/.config/rncbc.org
    install -m 0644 ${WORKDIR}/QjackCtl.conf ${D}/${sysconfdir}/skel/.config/rncbc.org/
}

PACKAGES =+ "${PN}-defconfig"

FILES_${PN}-defconfig = " \
    ${sysconfdir}/skel/.config/rncbc.org \
"

RDEPENDS_${PN} += " \
    jack-server \
"

RDEPENDS_${PN}-defconfig += " \
    a2jmidid \
    audio-tweaks \
"
