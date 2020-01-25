SUMMARY = "Ardour is a multi-channel digital audio workstation"
HOMEPAGE = "http://ardour.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"

DEPENDS += " \
    gettext-native \
    gtk+ \
    gtkmm \
    cppunit \
    jack \
    alsa-lib \
    fftw \
    vamp-plugin-sdk \
    aubio \
    taglib \
    boost \
    virtual/libx11 \
    dssi \
    zlib \
    lrdf \
    rubberband \
    suil \
    lilv \
    libarchive \
    libltc \
    qm-dsp \
    fluidsynth \
"

inherit waf features_check gtk-icon-cache pkgconfig python3native mime-xdg

REQUIRED_DISTRO_FEATURE = "x11"

SRC_URI = " \
    git://github.com/Ardour/ardour.git \
    file://waf-backport/waf \
    file://waf-backport/0001-Towards-waf-python-2-3-support.patch \
    file://waf-backport/0002-Update-waf-to-v2.0.19.patch \
    file://waf-backport/0003-Change-waf-darwin-default-compiler-to-prefer-gcc-if-.patch \
    file://waf-backport/0004-Tweaks-to-build-package-scripts-for-new-waf.patch \
    file://waf-backport/0005-Downgrade-using-all-channels-warning-to-info-part-2.patch \
    file://waf-backport/0006-Update-waf2.x-subst-feature-uses-obj-attributes.patch \
    file://waf-backport/0007-a-comp.lv2-wscript-sync-to-master.patch \
    file://0001-remove-all-build-flags-that-cause-trouble-for-cross-.patch \
    file://0002-Use-ARM-NEON-intrinsics-if-available-for-mixing-func.patch \
    file://0003-Prevent-excessive-meter-redraws-for-inactive-meters-.patch \
    file://0004-Prevent-excessive-meter-redraws-for-inactive-meters-.patch \
    file://0005-Follow-fluidsynth-s-API-changes-introduced-with-2.0..patch \
    file://0006-Find-fmt-binding-in-out-of-tree-building.patch \
    file://ardour5.desktop \
"
SRCREV = "ae0dcdc0c5d13483271065c360e378202d20170a"
PV = "5.12"
S = "${WORKDIR}/git"

# arch specific override - default (tested) is ARM -> no fpu-optimizations
# can be something like i686 / x86_64 see file 'wscript' in sourcepath for more details
BUILD_DIST_TARGET ??= "none"

EXTRA_OECONF = " \
    --configdir=${sysconfdir} \
    --bindir=${bindir} \
    --libdir=${libdir} \
    --optimize \
    --cxx11 \
    --no-phone-home \
    --use-external-libs \
    --qm-dsp-include=${STAGING_INCDIR}/qm-dsp \
    \
    --with-backends="jack,alsa" \
    --dist-target=${BUILD_DIST_TARGET} \
"

PATH_append = ":${B}"

# Asking fails - waf supports --bindir / --libdir
waf_preconfigure() {
}

do_configure_prepend() {
    # link python -> python3
    ln -sf `which python3` ${B}/python
    # copy waf
    cp -f ${WORKDIR}/waf-backport/waf ${S}/
}

do_install_append() {
    # install icons to freedesktop locations
    for s in 16 22 32 48 256 512; do
        install -d  ${D}${datadir}/icons/hicolor/${s}x${s}/apps
        ln -s ../../../../${BPN}/resources/Ardour-icon_${s}px.png \
            ${D}${datadir}/icons/hicolor/${s}x${s}/apps/${BPN}.png
    done

    # install .desktop
    install -d  ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/ardour5.desktop ${D}${datadir}/applications
}

FILES_${PN} += " \
    ${datadir}/${BPN} \
    ${libdir}/${BPN} \
"

FILES_${PN}-dev += " \
    ${libdir}/${BPN}/libardour.so \
    ${libdir}/${BPN}/libardouralsautil.so \
    ${libdir}/${BPN}/libaudiographer.so \
    ${libdir}/${BPN}/libcanvas.so \
    ${libdir}/${BPN}/libevoral.so \
    ${libdir}/${BPN}/libgtkmm2ext.so \
    ${libdir}/${BPN}/libmidipp.so \
    ${libdir}/${BPN}/libpbd.so \
    ${libdir}/${BPN}/libptformat.so \
    ${libdir}/${BPN}/libwaveview.so \
    ${libdir}/${BPN}/libwidgets.so \
    ${libdir}/${BPN}/vamp/*.so \
"

FILES_${PN}-staticdev += " \
    ${libdir}/${BPN}/*.a \
"
